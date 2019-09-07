package drawing;

import java.util.ArrayList;

public class CDC {
    public Object SelectObject(CPen pen) {
        return null;
    }
    public void Rectangle(double a ,double b,double c,double d){};

    public Object SelectObject(CBrush brush) {
        return null;
    }
    public void Ellipse(double a ,double b,double c,double d){}

    public void Polygon(ArrayList<CPoint> points, int i) {
    }

    public void SetBkColor(COLORREF fillColor) {
    }

    public void SetTextColor(COLORREF borderColor) {
    }

    public Object SelectObject(CFont pNewFont) {
        return null;
    }

    public void TextOut(int orgX, int orgY, String text) {
    }

    public CSize GetTextExtent(String text) {
        return null;
    }
}
