package com.jikisan.vstech;

import com.jikisan.vstech.Model.DataModel;
import com.jikisan.vstech.Model.DateListModel;
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
    private DataModel dataModel;
    private TemperatureToYPointMapper mapper;
    
        private List<String> dateTimeList = new ArrayList<String>();


    public TprSheetPanel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGrid(g, totalRows, totalColumns);
        fillDates(g);
        setData(g);
        drawTempLine(g);
        
        DateListModel dates = dataModel.getDateList();
        Mapper.getXpointsMap(dates.getDateArray());

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
                }
            }
        }

        int y = 9;
        for (int i = 9; i <= columns; i++) {
            int x = i * colWidth;
            if (i == y) {
                y += 6;
                g.drawLine(x, rowHeight * 45, x, gridHeight);
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
            g.drawString("Blood Pressure", textRow(fourthLabelRow, 10), textColumn(fourthLabelColumn));
            fourthLabelRow += 6;
        }

    }

    public void fillDates(Graphics g) {

        DateListModel dates = dataModel.getDateList();

        int row = 8;
        int column = 1;
        for (String date : dates.getDateArray()) {
            g.drawString(date, textRow(row, 1), textColumn(column));
            row += 6;
        }
        repaint();
    }

    public void setData(Graphics g) {
        repaint();
    }

    private void drawTempLine(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        float lineThickness = 5.0f;
        g2d.setStroke(new BasicStroke(lineThickness));
        // 12AM = 6
        // 4AM = 7
        // 8AM = 8

        //36.5 degrees = 16.5
        //36.6 degrees = 16.6
        //36.7 degrees = 16.7
        //36.8 degrees = 16.8
        //36.9 degrees = 16.9
        // 37 degrees = 17
        // 37.5 degrees = 16
        // 38 degrees = 15
        // 38.5 degrees = 14
        // 39 degrees = 13
        //Input: 12AM 37.5
        //Output: xPoints = {tempRow(6)}, yPoints = {tempColumn(16)}
        //Input: 4AM 37
        //Output: xPoints = {tempRow(7)}, yPoints = {tempColumn(17)}
        //Input: 8AM 37.5
        //Output: xPoints = {tempRow(8)}, yPoints = {tempColumn(18)}
        

        g.setColor(Color.BLACK);

        int[] xPoints = {
            tempRow(6),
            tempRow(7),
            tempRow(8)
        };
        int[] yPoints = {
            tempColumn(16),
            tempColumn(17),
            tempColumn(18)
        };
//        int[] xPoints = {tempRow(6)};
//        int[] yPoints = {tempColumn(16)};

        if (xPoints.length <= 1) {
            g.fillOval(xPoints[0], yPoints[0], 10, 10);
        } else {
            g.drawPolyline(xPoints, yPoints, xPoints.length);
        }
    }

    private int tempRow(int columnNum) {
        int colWidth = getWidth() / totalColumns;
        int row = (colWidth * columnNum) + (colWidth / 2);
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

}
