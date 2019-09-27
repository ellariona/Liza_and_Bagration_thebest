package functions;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {
    private Node head;
    private Node last;
    protected int count;

    private void addNode(double x, double y) {
        Node newNode = new Node();
        newNode.x = x;
        newNode.y = y;
        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.prev = last;
            newNode.next = head;
            last.next = newNode;
            head.prev = newNode;
        }
        last = newNode;
        count++;
    }

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        for (int i = 0; i < count; i++) {
            this.addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) {
            double z = xTo;
            xTo = xFrom;
            xFrom = xTo;
        }
        double stepX = (xTo - xFrom) / (count + 1);
        if (xFrom != xTo) {
            for (int i = 0; i < count; i++)
                addNode(xFrom + stepX * i, source.apply(xFrom + stepX * i));
        } else
            for (int i = 0; i < count; i++) {
                addNode(xFrom, source.apply(xFrom));
            }
    }

    public int getCount() {
        return count;
    }

    public double leftBound() {
        return head.x;
    }

    public double rightBound() {
        return last.x;
    }

    private Node getNode(int index) {
        Node finding = head;
        for (int i = 0; i < index; i++)
            finding = finding.next;
        return finding;
    }

    public double getX(int index) {
        return getNode(index).x;
    }

    public double getY(int index) {
        return getNode(index).y;
    }

    public void setY(int index, double y) {
        getNode(index).y = y;
    }

    public int indexOfX(double x) {
        for (int i = 0; i < count; i++) {
            if (x == this.getX(i))
                return i;
        }
        return -1;
    }

    public int indexOfY(double y) {
        for (int i = 0; i < count; i++) {
            if (y == this.getY(i))
                return i;
        }
        return -1;
    }

    @Override
    public int floorIndexOfX(double x) {
        if (x < head.x)
            return 0;
        if (x > last.x)
            return count;
        for (int i = 1; i < count; i++) {
            if (x < getX(i))
                return i - 1;
        }
        return count;
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        if (count == 1)
            return head.y;
        Node left = getNode(floorIndex);
        Node right = left.next;
        return left.y + (right.y - left.y) / (right.x - left.x) * (x - left.x);
    }

    @Override
    protected double extrapolateRight(double x) {
        Node left = last.prev;
        return left.y + (last.y - left.y) / (last.x - left.x) * (x - left.x);
    }

    @Override
    protected double extrapolateLeft(double x) {
        Node right = head.next;
        return head.y + (right.y - head.y) / (right.x - head.x) * (x - head.x);
    }
}

class Node {
    public Node next;
    public Node prev;
    public double x;
    public double y;
}