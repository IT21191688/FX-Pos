package com.supershop.pos.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.supershop.pos.util.QrDataGenerator;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public class NewBatchForm {


    public ImageView barcodeImg;



    public void initialize() throws WriterException {

        setQrCode();
    }

    private void setQrCode() throws WriterException {

        String uniqueData= QrDataGenerator.generate(25);

        //gen qr

        QRCodeWriter qrCodeWriter=new QRCodeWriter();
        BufferedImage bufferedImage= MatrixToImageWriter.toBufferedImage(

                qrCodeWriter.encode(uniqueData, BarcodeFormat.QR_CODE,194,162)
        );

        Image image= SwingFXUtils.toFXImage(bufferedImage,null);

        barcodeImg.setImage(image);

    }


    public void backCancelOnAction(ActionEvent event) {
    }

    public void btnSubmitBatchOnAction(ActionEvent event) {
    }
}
