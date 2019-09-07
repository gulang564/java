package shape;

import drawing.*;

import java.lang.annotation.ElementType;
import java.util.LinkedList;

import static com.sun.imageio.plugins.jpeg.JPEG.DEFAULT_QUALITY;
import static java.lang.Boolean.FALSE;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class CText extends CShape {
    private final ElementType TEXT=null;
    private Object ANSI_CHARSET;
    private Object OUT_DEFAULT_PRECIS;
    private Object CLIP_DEFAULT_PRECIS;

    private Object DEFAULT_PITCH;
    private Object FF_SWISS;

    public	CText(){};

    @Override
    public void Draw(CDC pDC) {
        pDC.SetBkColor(FillColor);											//设置背景颜色
        pDC.SetTextColor(BorderColor);										//设置字体颜色

        CFont pOldFont;
        CFont pNewFont = new CFont();

        pNewFont.CreateFont(height, 0, angle * 10, angle * 10, 200,
                FALSE, FALSE, 0, ANSI_CHARSET, OUT_DEFAULT_PRECIS,
                CLIP_DEFAULT_PRECIS,
                DEFAULT_QUALITY, DEFAULT_PITCH,FF_SWISS, "Aerial");
        pOldFont = (CFont )pDC.SelectObject(pNewFont);
        pDC.TextOut(OrgX, OrgY, text);
        size = pDC.GetTextExtent(text);									//获取文本的高度和宽度
        pDC.SelectObject(pOldFont);




    }

    @Override
    public boolean IsMatched(CPoint pnt) {
        double width, height;
        width = size.cx;									// cx、cy分别是宽度和高度
        height = size.cy;
        double a = angle * 3.1415926 / 180;
       LinkedList<POINT>  p=new LinkedList<POINT>();
        p.get(0).x = OrgX;
        p.get(0).y = OrgY;
        p.get(1).x = OrgX + height * sin(a);
        p.get(1).y = OrgY + height * cos(a);
        p.get(2).x = OrgX + height * sin(a) + width * cos(a);
        p.get(2).y = OrgY + height * cos(a) - width * sin(a);
        p.get(3).x = OrgX + width * cos(a);
        p.get(3).y = OrgY - width * sin(a);
        int nCross = 0;
        for (int i = 0; i < 4; i++)
        {
            POINT p1 = p.get(i);
            POINT p2 = p.get((i + 1) % 4);// 最后一个点与第一个点连线
            if (p1.y == p2.y)
                continue;
            if (pnt.y < min(p1.y, p2.y))
                continue;
            if (pnt.y >= max(p1.y, p2.y))
                continue;
            // 求交点的x坐标
            double x = (double)(pnt.y - p1.y) * (double)(p2.x - p1.x) / (double)(p2.y - p1.y) + p1.x;
            // 只统计p1p2与p向右射线的交点
            if (x > pnt.x)
            {
                nCross++;
            }
        }    // 交点为偶数，点在多边形之外
        if (nCross % 2 == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void Serialize(CArchive ar) {
        if (ar.IsStoring())
        {
//            ar << (WORD)Type;
//            ar << OrgX << OrgY;	//原点坐标
//            ar << BorderColor;	//边界颜色
//            ar << BorderType;	//边界线型
//            ar << BorderWidth;	//边界宽度
//            ar << FillColor;	//填充颜色
//            ar << FillType;		//填充类型
//            ar << height;		//文本的高
//            ar << angle;		//文本与X轴的角度
//            ar << text;			//文本内容
//            ar << size;
        }
        else
        {
//            WORD w;
//            ar >> w;
//            Type = (ElementType)w;
//            ar >> OrgX >> OrgY;	//原点坐标
//            ar >> BorderColor;	//边界颜色
//            ar >> BorderType;	//边界线型
//            ar >> BorderWidth;	//边界宽度
//            ar >> FillColor;	//填充颜色
//            ar >> FillType;		//填充类型
//            ar >> height;		//文本的高
//            ar >> angle;		//文本与X轴的角度
//            ar >> text;			//文本内容
//            ar >> size;
        }
    }

    public	CText(int x, int y, int h, int a, String t){
        Type = TEXT;
        OrgX = x;
        OrgY = y;
        height = h;
        angle = a;
        text = t;

    };
    public	void SetValue(int x, int y, int w_r, int h, String s){
        OrgX = x;
        OrgY = y;
        angle = w_r;
        height = h;
        text = s;

    };
    public	void GetValue(int type, int x, int y, int w_r, int h, String s)
    {
        type = 5;
        x = OrgX;
        y = OrgY;
        w_r = angle;
        h = height;
        s = text;
    };

    private	int height;
    private	int angle;
    private	String text;
    private CSize size;

}
