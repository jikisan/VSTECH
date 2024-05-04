package com.jikisan.vstech;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class TprSheetPanel extends JPanel {

    private final int totalRows = 51;
    private final int totalColumns = 36;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGrid(g, totalRows, totalColumns);

//        drawConnectedLine(g); // Draw lines using specified row/column coordinates
    }

    private void drawGrid(Graphics g, int rows, int columns) {
        int width = getWidth();
        int height = getHeight();
        int rowHeight = height / rows;
        int colWidth = width / columns;
        int gridWidth = width - colWidth;
        int gridHeight = height;

        //Horizontal Line
        for (int i = 0; i <= rows; i++) {
            int y = i * rowHeight; // Y-coordinate for each row

            if (i == 2 || i == 3) {
                g.drawLine(colWidth * 6, y, gridWidth, y);
            } else {
                g.drawLine(0, y, gridWidth, y);
            }
        }

        //Vertical Line
        for (int i = 0; i <= columns; i++) {
            int x = i * colWidth; // X-coordinate for each column

            if (i % 6 == 0) {
                g.drawLine(x, 0, x, gridHeight);
            } else if (i % 3 == 0) {
                g.drawLine(x, rowHeight, x, gridHeight );
            } else {
                if (i < 6) {
                    continue;
                } else {
                    g.drawLine(x, rowHeight * 2, x, gridHeight);
                }
            }
        }

        setStaticText(g, colWidth, rowHeight);
    }

    private void setStaticText(Graphics g, int colWidth, int rowHeight) {

        String[] firstLabel = {
            "200", "180", "170", "160", "150", "140", "130", "120", "110", "100",
            "90", "80", "70", "60", "50", "40", "30", "20", "10", "0"
        };

        String[] secondLabel = {
            "43", "42", "41", "40", "39", "38", "37", "36", "35", "34", "32", "30"
        };

        g.setFont(new Font("Verdana", Font.BOLD, 12));
        g.setColor(Color.BLACK);

        g.drawString("Date", textRow(2, 2, colWidth), textColumn(1, rowHeight));

        g.drawString("PR", textRow(1, 2, colWidth), textColumn(2, rowHeight));
        g.drawString("TE", textRow(4, 2, colWidth), textColumn(2, rowHeight));

        g.drawString("RR", textRow(1, 2, colWidth), textColumn(3, rowHeight));
        g.drawString("MP", textRow(4, 2, colWidth), textColumn(3, rowHeight));
        g.drawString("°C", textRow(4, 2, colWidth), textColumn(4, rowHeight));

        g.drawString("AM", textRow(6, 1, colWidth), textColumn(2, rowHeight));
        g.drawString("PM", textRow(9, 1, colWidth), textColumn(2, rowHeight));

        g.drawString("AM", textRow(12, 1, colWidth), textColumn(2, rowHeight));
        g.drawString("PM", textRow(15, 1, colWidth), textColumn(2, rowHeight));

        g.drawString("AM", textRow(18, 1, colWidth), textColumn(2, rowHeight));
        g.drawString("PM", textRow(21, 1, colWidth), textColumn(2, rowHeight));

        g.drawString("AM", textRow(24, 1, colWidth), textColumn(2, rowHeight));
        g.drawString("PM", textRow(27, 1, colWidth), textColumn(2, rowHeight));

        g.drawString("AM", textRow(30, 1, colWidth), textColumn(2, rowHeight));
        g.drawString("PM", textRow(33, 1, colWidth), textColumn(2, rowHeight));

       
        
        int firstLabelRow = 1;
        int firstLabelColumn = 6;
        for (String label : firstLabel) {
            firstLabelColumn += 2;
            g.drawString(label, textRow(firstLabelRow, 1, colWidth), textColumn(firstLabelColumn, rowHeight));
        }
        
        int secondtLabelRow = 4;
        int secondtLabelColumn = 6;
        for (String label : secondLabel) {
            secondtLabelColumn += 2;
            g.drawString(label, textRow(secondtLabelRow, 1, colWidth), textColumn(secondtLabelColumn, rowHeight));
        }

    }

    private int textRow(int columnNum, int num2, int colWidth) {
        int row = (colWidth * columnNum) + (colWidth / num2);
        return row;
    }

    private int textColumn(int rowNum, int rowHeight) {
        rowNum -= 1;
        int column = (int) (((rowHeight * rowNum) + (rowHeight * .8)));
        return column;
    }

//    private void drawConnectedLine(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g; // Cast to Graphics2D for advanced features
//
//        float lineThickness = 5.0f;
//        g2d.setStroke(new BasicStroke(lineThickness));
//
//        g.setColor(Color.BLUE);
//
//        // Plot lines at specific row/column coordinates
//        int[] xPoints = {getColCoordinate(1), getColCoordinate(2)};
//        int[] yPoints = {getRowCoordinate(12), getRowCoordinate(11)};
//
//        g.drawPolyline(xPoints, yPoints, xPoints.length); // Draw connected lines between points
//    }
//
//    private int getRowCoordinate(int row) {
//        int height = getHeight();
//        int rowHeight = height / totalRows;
//        return row * rowHeight; // Y-coordinate based on row
//    }
//
//    private int getColCoordinate(int col) {
//        int width = getWidth();
//        int colWidth = width / totalColumns;
//        return col * colWidth; // X-coordinate based on column
//    }
}
