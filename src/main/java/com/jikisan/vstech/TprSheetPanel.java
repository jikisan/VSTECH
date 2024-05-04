package com.jikisan.vstech;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

public class TprSheetPanel extends JPanel {

    private final int totalRows = 51;
    private final int totalColumns = 36;
    private List<String> data = new ArrayList<String>(); // Data to be displayed on the grid
    private List<String> dateList = new ArrayList<String>(); // Data to be displayed on the grid

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGrid(g, totalRows, totalColumns);
        fillUpDate(dateList, g);
        setData(dateList, g);
        drawTempLine(g);

//        drawConnectedLine(g); // Draw lines using specified row/column coordinates
    }

    private void drawGrid(Graphics g, int rows, int columns) {
        int width = getWidth();
        int height = getHeight();
        int rowHeight = height / rows;
        int colWidth = width / columns;
        int gridWidth = width - (colWidth / 2);
        int gridHeight = height;

        // Draw horizontal lines
        for (int i = 0; i <= rows; i++) {
            int y = i * rowHeight;
            int startX = (i == 2 || i == 3) ? colWidth * 6 : 0;
            g.drawLine(startX, y, gridWidth, y);
        }

        // Draw vertical lines
        for (int i = 0; i <= columns; i++) {
            int x = i * colWidth;
            if (i % 6 == 0) {
                g.drawLine(x, 0, x, gridHeight);
            } else if (i % 3 == 0) {
                int endY = (i == 3) ? gridHeight : gridHeight - (rowHeight * 7);
                g.drawLine(x, rowHeight, x, endY);
            } else {
                if (i > 6 && i % 3 != 0) {
                    g.drawLine(x, rowHeight * 2, x, gridHeight - (rowHeight * 7));
                } else {

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

        String[] thirdLabel = {
            "6-2", "2-10", "10-6"
        };

        g.setFont(new Font("Verdana", Font.BOLD, 12));
        g.setColor(Color.BLACK);

        g.drawString("Date", textRow(2, 15), textColumn(1));

        g.drawString("PR", textRow(1, 1), textColumn(2));
        g.drawString("TE", textRow(4, 1), textColumn(2));

        g.drawString("RR", textRow(1, 1), textColumn(3));
        g.drawString("MP", textRow(4, 1), textColumn(3));
        g.drawString("°C", textRow(4, 1), textColumn(4));

        g.drawString("AM", textRow(7, 5), textColumn(2));
        g.drawString("PM", textRow(10, 5), textColumn(2));

        g.drawString("AM", textRow(13, 5), textColumn(2));
        g.drawString("PM", textRow(16, 5), textColumn(2));

        g.drawString("AM", textRow(19, 5), textColumn(2));
        g.drawString("PM", textRow(22, 5), textColumn(2));

        g.drawString("AM", textRow(25, 5), textColumn(2));
        g.drawString("PM", textRow(28, 5), textColumn(2));

        g.drawString("AM", textRow(31, 5), textColumn(2));
        g.drawString("PM", textRow(34, 5), textColumn(2));

        int firstLabelRow = 1;
        int firstLabelColumn = 4;
        for (String label : firstLabel) {
            firstLabelColumn += 2;
            g.drawString(label, textRow(firstLabelRow, 1), textColumn(firstLabelColumn));
        }

        int secondtLabelRow = 4;
        int secondtLabelColumn = 4;
        for (String label : secondLabel) {
            secondtLabelColumn += 2;
            g.drawString(label, textRow(secondtLabelRow, 1), textColumn(secondtLabelColumn));
        }

        int thirdLabelRow = 4;
        int thirdLabelColumn = 45;
        for (String label : thirdLabel) {
            thirdLabelColumn += 1;
            g.drawString(label, textRow(thirdLabelRow, 1), textColumn(thirdLabelColumn));
        }

        g.drawString("12", textRow(6, 5), textColumn(3));
        g.drawString("4", textRow(7, 10), textColumn(3));
        g.drawString("8", textRow(8, 10), textColumn(3));
        g.drawString("12", textRow(9, 5), textColumn(4));
        g.drawString("4", textRow(10, 10), textColumn(4));
        g.drawString("8", textRow(11, 10), textColumn(4));

        g.drawString("12", textRow(12, 5), textColumn(3));
        g.drawString("4", textRow(13, 10), textColumn(3));
        g.drawString("8", textRow(14, 10), textColumn(3));
        g.drawString("12", textRow(15, 5), textColumn(4));
        g.drawString("4", textRow(16, 10), textColumn(4));
        g.drawString("8", textRow(17, 10), textColumn(4));

        g.drawString("12", textRow(18, 5), textColumn(3));
        g.drawString("4", textRow(19, 10), textColumn(3));
        g.drawString("8", textRow(20, 10), textColumn(3));
        g.drawString("12", textRow(21, 5), textColumn(4));
        g.drawString("4", textRow(22, 10), textColumn(4));
        g.drawString("8", textRow(23, 10), textColumn(4));

        g.drawString("12", textRow(24, 5), textColumn(3));
        g.drawString("4", textRow(25, 10), textColumn(3));
        g.drawString("8", textRow(26, 10), textColumn(3));
        g.drawString("12", textRow(27, 5), textColumn(4));
        g.drawString("4", textRow(28, 10), textColumn(4));
        g.drawString("8", textRow(29, 10), textColumn(4));

        g.drawString("12", textRow(30, 5), textColumn(3));
        g.drawString("4", textRow(31, 10), textColumn(3));
        g.drawString("8", textRow(32, 10), textColumn(3));
        g.drawString("12", textRow(33, 5), textColumn(4));
        g.drawString("4", textRow(34, 10), textColumn(4));
        g.drawString("8", textRow(35, 10), textColumn(4));

        int fourthLabelRow = 7;
        int fourthLabelColumn = 45;
        for (int i = 0; i < 5; i++) {
            g.drawString("Blood Pressure", textRow(fourthLabelRow, 1), textColumn(fourthLabelColumn));
            fourthLabelRow += 6;
        }

    }

    public void fillUpDate(List<String> datesList, Graphics g) {

        dateList.clear();
//        dateList.add("May 5");
//        dateList.add("May 6");
//        dateList.add("May 7");
//        dateList.add("May 8");
//        dateList.add("May 9");
//        dateList.add("May 10");
//        dateList.add("May 11");

        int row = 8;
        int column = 1;
        for (String date : datesList) {
            g.drawString(date, textRow(row, 1), textColumn(column));
            row += 6;
        }
        repaint(); // Repaint the panel to reflect the new data
    }

    public void setData(List<String> data, Graphics g) {
        this.data = data;
        repaint();
    }

    private void drawTempLine(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g; // Cast to Graphics2D for advanced features

        float lineThickness = 5.0f;
        g2d.setStroke(new BasicStroke(lineThickness));

        g.setColor(Color.BLACK);
        
        // 12AM = 6
        // 4AM = 7
        // 8AM = 8
        
        // 37 degrees = 17
        // 37.5 degrees = 16
        // 38 degrees = 15
        // 38.5 degrees = 14
        // 39 degrees = 13
        
        int[] xPoints = {tempRow(6),  tempRow(7), tempRow(8)};
        int[] yPoints = {tempColumn(16), tempColumn(17), tempColumn(18)};

        g.drawPolyline(xPoints, yPoints, xPoints.length);
    }

    private int tempRow(int columnNum) {
        int colWidth = getWidth() / totalColumns;
        int row = (colWidth * columnNum) +(colWidth / 2);
        return row;
    }

    private int tempColumn(int rowNum) {
        int rowHeight = getHeight() / totalRows;
        int column = (int) ((rowHeight * rowNum) + (rowHeight / 2));
        return column;
    }
    
    private int textRow(int columnNum, int num2) {
        int colWidth = getWidth() / totalColumns;
        int row = (colWidth * columnNum) + num2;
        return row;
    }

    private int textColumn(int rowNum) {
        rowNum -= 1;
        int rowHeight = getHeight() / totalRows;
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
