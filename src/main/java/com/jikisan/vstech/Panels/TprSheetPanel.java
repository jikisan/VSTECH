package com.jikisan.vstech.Panels;

import com.jikisan.vstech.Mapper;
import com.jikisan.vstech.Model.*;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.JPanel;

public class TprSheetPanel extends JPanel {

    private final Map<String, Integer> dateTimeMapper;
    private final Map<String, Integer> bpXpointsMap;
    private final Map<String, Integer> tempMapper;
    private final Map<String, Integer> prMapper;

    private List<TempDataModel> tempList;
    private List<PrDataModel> prList;
    private List<RrDataModel> rrList;
    private List<BpDataModel> bpList;

    private String[] dateLabels;

    private final int totalRows = 51;
    private final int totalColumns = 36;
    private final float lineThickness = 3.0f;

    public TprSheetPanel(DataModel dataModel, Map<String, Integer> _dateTimeMap, Map<String, Integer> _bpXpointsMap, String[] dates) {
        this.dateTimeMapper = _dateTimeMap;
        this.bpXpointsMap = _bpXpointsMap;
        this.tempMapper = Mapper.getTempYpointsMap();
        this.prMapper = Mapper.getPrYpointsMap();
        this.dateLabels = dates;

        tempList = dataModel.getTempData() == null ? new ArrayList<TempDataModel>() : dataModel.getTempData();
        prList = dataModel.getPrData() == null ? new ArrayList<PrDataModel>() : dataModel.getPrData();
        rrList = dataModel.getRrData() == null ? new ArrayList<RrDataModel>() : dataModel.getRrData();
        bpList = dataModel.getBpData() == null ? new ArrayList<BpDataModel>() : dataModel.getBpData();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        setMinimumSize(new Dimension(1000, 1000));
        setBackground(Color.WHITE);
        setAutoscrolls(true);

        drawGrid(g, totalRows, totalColumns);
        fillDates(g);
        fillBpData(g);
        drawTempLine(g);
        drawPrLine(g);
        drawRrLine(g);
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
                int endY = (i == 3) ? gridHeight : gridHeight - (rowHeight * 10);
                g.drawLine(x, rowHeight, x, endY);
            } else {
                if (i > 6 && i % 3 != 0) {
                    g.drawLine(x, rowHeight * 2, x, gridHeight - (rowHeight * 10));
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

        g.setFont(new Font("Verdana", Font.BOLD, 10));
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
        int row = 8;
        int column = 1;
        for (String date : dateLabels) {
            g.drawString(date, textRow(row, 1), textColumn(column));
            row += 6;
        }

        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(lineThickness));

//        repaint();

    }

    private void drawTempLine(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(lineThickness));
        g.setColor(Color.BLACK);

        int skipCount = 0;

        for (int i = 0; i < tempList.size(); i++) {
            String temp = tempList.get(i).getTemp();
            if (temp.equalsIgnoreCase("skip")) {
                skipCount++;
            }
        }


        int[] xPoints = new int[tempList.size() - skipCount];
        int[] yPoints = new int[tempList.size() - skipCount];

        for (int i = 0; i < xPoints.length; i++) {
            String date = tempList.get(i + skipCount).getDate();
            String temp = tempList.get(i + skipCount).getTemp();

            if (!temp.equalsIgnoreCase("skip")) {
                xPoints[i] = dateXpoint(date);
                yPoints[i] = tempYpoint(temp);
                System.out.println("not skip");
            }
        }

        if (xPoints.length == 1) {
            g.fillOval(xPoints[0], yPoints[0], 5, 5);
        } else if (xPoints.length > 1) {
            g.drawPolyline(xPoints, yPoints, xPoints.length);
        }
    }

    private void drawPrLine(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(lineThickness));
        g.setColor(Color.RED);

        int skipCount = 0;

        for (int i = 0; i < prList.size(); i++) {
            String pr = prList.get(i).getPR();
            if (pr.equalsIgnoreCase("skip")) {
                skipCount++;
            }
        }

        int[] xPoints = new int[prList.size() - skipCount];
        int[] yPoints = new int[prList.size() - skipCount];

        for (int i = 0; i < xPoints.length; i++) {
            String date = prList.get(i + skipCount).getDate();
            String pr = prList.get(i + skipCount).getPR();

            if (!pr.equalsIgnoreCase("skip")) {
                xPoints[i] = dateXpoint(date);
                yPoints[i] = prYpoint(pr);
            }
        }

        if (xPoints.length == 1) {
            g.fillOval(xPoints[0], yPoints[0], 5, 5);
        } else if (xPoints.length > 1) {
            g.drawPolyline(xPoints, yPoints, xPoints.length);
        }
    }

    private void drawRrLine(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(lineThickness));
        g.setColor(Color.BLUE);

        int skipCount = 0;

        for (int i = 0; i < rrList.size(); i++) {
            String rr = rrList.get(i).getRR();
            if (rr.equalsIgnoreCase("skip")) {
                skipCount++;
            }
        }

        int[] xPoints = new int[rrList.size() - skipCount];
        int[] yPoints = new int[rrList.size() - skipCount];


        for (int i = 0; i < xPoints.length; i++) {
            String date = rrList.get(i + skipCount).getDate();
            String rr = rrList.get(i + skipCount).getRR();

            if (!rr.equalsIgnoreCase("skip")) {
                xPoints[i] = dateXpoint(date);
                yPoints[i] = prYpoint(rr);
            }
        }

        if (xPoints.length == 1) {
            g.fillOval(xPoints[0], yPoints[0], 5, 5);
        } else if (xPoints.length > 1) {
            g.drawPolyline(xPoints, yPoints, xPoints.length);
        }

//        repaint();
    }

    private void fillBpData(Graphics g) {

        int column = 47;
        for (BpDataModel bp : bpList) {

            int row = bpXpoint(bp.getDate());

            switch (bp.getHour()) {
                case "6-2":
                    column = 46;
                    break;
                case "2-10":
                    column = 47;
                    break;
                case "10-6":
                    column = 48;
                    break;
            }

            g.drawString(bp.getBp(), textRow(row, 15), textColumn(column));
        }

        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(lineThickness));

//        repaint();
    }



    private int dateXpoint(String dateTime) {
        int columnNum = dateTimeMapper.get(dateTime.toLowerCase());
        int colWidth = getWidth() / totalColumns;
        int row = (colWidth * columnNum) + (colWidth / 2);
        return row;
    }

    private int bpXpoint(String dateTime) {
        int columnNum = bpXpointsMap.get(dateTime.toLowerCase());
        int colWidth = getWidth() / totalColumns;
        int row = (colWidth * columnNum) + (colWidth / 2);
        return columnNum;
    }

    private int tempYpoint(String temp) {
        int rowNum = tempMapper.get(temp) == null ? 43 : tempMapper.get(temp);
        int rowHeight = getHeight() / totalRows;
        int offSet = temp.contains(".") ? (rowHeight / 2) : 0;
        int column = (int) ((rowHeight * (rowNum + 1) - offSet));
        return column;
    }

    private int prYpoint(String pr) {
        int rowNum = prMapper.get(pr) == null ? 0 : prMapper.get(pr);
        int rowHeight = getHeight() / totalRows;
        int offSet = Integer.parseInt(pr) % 5 == 0 ? 0 : (rowHeight / 2);
        int column = (int) ((rowHeight * (rowNum + 1) - offSet));
        return column;
    }

    private int textRow(int columnNum, int leftOffset) {
        int colWidth = getWidth() / totalColumns;
        int row = (colWidth * columnNum) + leftOffset;
        return row;
    }

    private int textColumn(int rowNum) {
        rowNum -= 1;
        int rowHeight = getHeight() / totalRows;
        int column = (int) (((rowHeight * rowNum) + (rowHeight * .8)));
        return column;
    }

    private int countOccurrences(List<BpDataModel> list, String target) {
        int sixToTwoCount = 0;
        int twoToTenCount = 0;
        int tenToSixCount = 0;
        int count = 0;

        for (BpDataModel item : list) {
            switch (item.getHour()) {
                case "6-2":
                    sixToTwoCount++;
                    count = sixToTwoCount;
                    break;
                case "2-10":
                    twoToTenCount++;
                    count = twoToTenCount;
                    break;
                case "10-6":
                    tenToSixCount++;
                    count = tenToSixCount;
                    break;
            }
        }
        return count;
    }

}
