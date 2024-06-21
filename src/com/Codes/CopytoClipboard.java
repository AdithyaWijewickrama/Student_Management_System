package com.Codes;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class CopytoClipboard implements ClipboardOwner{

    public void CopyImagetoClipBoard(String path, int width, int height) {
        Image img = Commons.getImage(path, width, height).getImage();
        TransferableImage trans = new TransferableImage(img);
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        c.setContents(trans, this);
    }
    
    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {

    }
}

class TransferableImage implements Transferable {

    Image i;

    public TransferableImage(Image i) {
        this.i = i;
    }

    @Override
    public Object getTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException, IOException {
        if (flavor.equals(DataFlavor.imageFlavor) && i != null) {
            return i;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        DataFlavor[] flavors = new DataFlavor[1];
        flavors[0] = DataFlavor.imageFlavor;
        return flavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        DataFlavor[] flavors = getTransferDataFlavors();
        for (DataFlavor flavor1 : flavors) {
            if (flavor.equals(flavor1)) {
                return true;
            }
        }

        return false;
    }
}
