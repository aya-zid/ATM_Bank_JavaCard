package monpackageclient;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.sun.javacard.apduio.*;
import com.sun.javacard.apduio.Apdu;
import com.sun.javacard.apduio.CadT1Client;
import com.sun.javacard.apduio.CadTransportException;
import javacard.framework.Util;

public class MaClasse {
     public static final byte CLA_MONAPPLET = (byte) 0xB0;
     public static final byte INS_VERIFY_PIN= 0x00;
	 public static final byte INS_INCREMENTER_COMPTEUR = 0x01; 
	 public static final byte INS_DECREMENTER_COMPTEUR = 0x02; 
	 public static final byte INS_INTERROGER_COMPTEUR = 0x03;  
     public int i=0;
     private CadT1Client cad;

    public MaClasse() throws IOException, CadTransportException {
        Socket sckCarte = new Socket("localhost", 9025);
        sckCarte.setTcpNoDelay(true);
        BufferedInputStream input = new BufferedInputStream(sckCarte.getInputStream());
        BufferedOutputStream output = new BufferedOutputStream(sckCarte.getOutputStream());
        cad = new CadT1Client(input, output);
        cad.powerUp();
        selectApplet();
    }
    public void selectApplet() {
        Apdu apdu = new Apdu();
        apdu.command[Apdu.CLA] = 0x00;
        apdu.command[Apdu.INS] = (byte) 0xA4;
        apdu.command[Apdu.P1] = 0x04;
        apdu.command[Apdu.P2] = 0x00;
        byte[] appletAID = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x00, 0x00 };
        apdu.setDataIn(appletAID);

        try {
            cad.exchangeApdu(apdu);
            if (apdu.getStatus() != 0x9000) {
                System.out.println("Error selecting applet");
                System.exit(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static byte[] shortToByteArray(short value) {
        return new byte[] {
            (byte) ((value >> 8) & 0xFF), // Most significant byte
            (byte) (value & 0xFF)         // Least significant byte
        };
    }
    public short creditAmount(short amount) {
    	//short h ;
        Apdu apdu = new Apdu();
        apdu.command[Apdu.CLA] = MaClasse.CLA_MONAPPLET;
        apdu.command[Apdu.INS] = MaClasse.INS_INCREMENTER_COMPTEUR;
        apdu.command[Apdu.P1] = 0x00;
        apdu.command[Apdu.P2] = 0x00;
        apdu.setDataIn(shortToByteArray(amount));
        
        try {
            cad.exchangeApdu(apdu);
            if (apdu.getStatus() != 0x9000) {
               return-1;
            
            } else {
            	try {
                    // Writing transaction data to a file
                    FileWriter fileWriter = new FileWriter("C:\\Users\\Hajer Mlayeh\\eclipse-workspace\\ApplicationClient\\transaction_history.txt", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    
                    LocalDateTime currentTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String formattedDateTime = currentTime.format(formatter);
                    
                    bufferedWriter.write(formattedDateTime + " Credit " + amount + "\n");
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            	  return 1;
              
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    public short debitAmount(short amount) {
        Apdu apdu = new Apdu();
        apdu.command[Apdu.CLA] = MaClasse.CLA_MONAPPLET;
        apdu.command[Apdu.INS] = MaClasse.INS_DECREMENTER_COMPTEUR;
        apdu.command[Apdu.P1] = 0x00;
        apdu.command[Apdu.P2] = 0x00;
        apdu.setDataIn(shortToByteArray(amount));

        try {
            cad.exchangeApdu(apdu);
            if (apdu.getStatus() != 0x9000) {
                return-1;
             } else {
            	 try {
                     // Writing transaction data to a file
                     FileWriter fileWriter = new FileWriter("transaction_history.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                     
                     LocalDateTime currentTime = LocalDateTime.now();
                     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                     String formattedDateTime = currentTime.format(formatter);
                     
                     bufferedWriter.write(formattedDateTime + " Debit " + amount + "\n");
                     bufferedWriter.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
               return 1;
           
             }
         } catch (Exception e) {
             e.printStackTrace();
         }   
         return 0;
         
    }
    public short checkBalance() {
        Apdu apdu = new Apdu();
        apdu.command[Apdu.CLA] = MaClasse.CLA_MONAPPLET;
        apdu.command[Apdu.INS] = MaClasse.INS_INTERROGER_COMPTEUR;
        apdu.command[Apdu.P1] = 0x00;
        apdu.command[Apdu.P2] = 0x00;

        try {
            cad.exchangeApdu(apdu);
            if (apdu.getStatus() != 0x9000) {
               // System.out.println("Error checking balance");
            	return -1;
            } else {
           
             
                
                short balance = (short)(((apdu.dataOut[0] & 0xFF) << 8) | (apdu.dataOut[1] & 0xFF));
             // In case the balance requires more bytes to represent
             if (apdu.dataOut.length > 2) {
                 int additionalBytes = apdu.dataOut.length - 2;
                 for (int i = 2; i < 2 + additionalBytes; i++) {
                     balance = (short)((balance << 8) | (apdu.dataOut[i] & 0xFF));
                 }
             }
       
                return balance;
              
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public short verifyPIN(byte[] pin) {
        Apdu apdu = new Apdu();
        apdu.command[Apdu.CLA] = CLA_MONAPPLET;
        apdu.command[Apdu.INS] = INS_VERIFY_PIN;
        apdu.command[Apdu.P1] = 0x00;
        apdu.command[Apdu.P2] = 0x00;
        apdu.setDataIn(pin);

        try {
            cad.exchangeApdu(apdu);
            if (apdu.getStatus() == 0x9000) {
                return 1; // PIN verification successful
                
            } else {
            	i++; 
            	if(i>=3)
            		return -2;
            	else 
            		return-1; //PIN verification failed
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }

    public void powerDown() {
        try {
            cad.powerDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}