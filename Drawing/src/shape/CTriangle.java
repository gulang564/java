package shape;

import drawing.*;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.LinkedList;

import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.sqrt;

public class CTriangle extends CShape {
    private final ElementType TRIANGLE=null;

    public	CTriangle(){};
    public	CTriangle(int x, int y, int w){
        Type = TRIANGLE;
        OrgX = x;
        OrgY = y;
        width = w;
    };
    private int HS_HORIZONTAL;
    private int HS_DIAGCROSS;


    @Override
    public void Draw(CDC pDC) {
        CPen pen=new CPen(),pOldPen;
        pen.CreatePen(BorderType, BorderWidth, BorderColor);			//画笔样式  画笔的线宽  画笔颜色
        pOldPen = (CPen)pDC.SelectObject(pen);						//保存原来画笔
        CBrush brush=new CBrush(), pOldBrush;										//创建画刷  进行颜色填充
        if (FillType >= HS_HORIZONTAL && FillType <= HS_DIAGCROSS)
            brush.CreateHatchBrush(FillType, FillColor);				//创建阴影画刷
        else
            brush.CreateSolidBrush(FillColor);							//创建图案画刷
        pOldBrush = (CBrush)pDC.SelectObject(brush);					//保存原来画刷
       ArrayList<CPoint> points=new ArrayList<CPoint>();
        points.get(0).x = OrgX;
        points.get(0).y =  (OrgY - width * 1.0 / sqrt(3));
        points.get(1).x = OrgX - width / 2.0;
        points.get(1).y = OrgY + width * 0.5 / sqrt(3);
        points.get(2).x = OrgX + width / 2.0;
        points.get(2).y = OrgY + width * 0.5 / sqrt(3);
        pDC.Polygon(points, 3);
        //BOOL Polygon(HDC hdc, CONST POINT *lpPoints, int nCount)；
        //句柄  用于指定多边形顶点的POINT结构数组的指针  顶点的个数
        pDC.SelectObject(pOldPen);										//恢复画笔
        pDC.SelectObject(pOldBrush);									//恢复画刷

    };//绘制三角形
    public	boolean IsMatched(CPoint pnt){
       LinkedList<CPoint> points=new LinkedList<>() ;

        points.get(0).x = OrgX;
        points.get(0).y = OrgY - width * 1.0 / sqrt(3);
        points.get(1).x = OrgX - width / 2.0;
        points.get(1).y = OrgY + width * 0.5 / sqrt(3);
        points.get(2).x = OrgX + width / 2.0;
        points.get(2).y = OrgY + width * 0.5 / sqrt(3);

        int nCross = 0;
        for (int i = 0; i < 3; i++)
        {
            CPoint p1 = points.get(i);
            CPoint p2 = points.get((i + 1) % 3);// 最后一个点与第一个点连线
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
        }

        // 交点为偶数，点在多边形之外

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
//            ar << width;		//正三角形的边长
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
//            ar >> width;		//正三角形的边长
        }
    }
    public	void SetValue(int x, int y, int w_r,  int h, String s){
        OrgX = x;
        OrgY = y;
        width = w_r;
    };
    public	void GetValue(int type, int x, int y, int w_r,  int h, String s){
        type = 4;
        x = OrgX;
        y = OrgY;
        w_r = width;
    };


    private	int width;
}
