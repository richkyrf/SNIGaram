/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KomponenGUI;

/**
 *
 * @author richk
 */
import Eror.LogEror;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class JPlaceHolder extends JTextField {

    private String placeholder;
    private char separator = '.';
    private int maxlimit = 2147483647;
    private int minlimit = -2147483647;

    public JPlaceHolder() {
        setFont(new java.awt.Font("Tahoma", 0, 18));
        setDisabledTextColor(Color.BLUE);
        setPlaceHolder("");
        setText("");
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                JPlaceHolder.this.setText(JPlaceHolder.this.getText());
                JPlaceHolder.this.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                JPlaceHolder.this.setText(JPlaceHolder.this.getText());
            }
        });
    }

    public JPlaceHolder(
            final Document pDoc,
            final String pText,
            final int pColumns) {
        super(pDoc, pText, pColumns);
    }

    public JPlaceHolder(final int pColumns) {
        super(pColumns);
    }

    public JPlaceHolder(final String pText) {
        super(pText);
    }

    public JPlaceHolder(final String pText, final int pColumns) {
        super(pText, pColumns);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.GRAY);
        g.drawString(placeholder, 3, pG.getFontMetrics().getMaxAscent() + 2);
    }

    public void setPlaceHolder(final String s) {
        placeholder = s;
    }

}
