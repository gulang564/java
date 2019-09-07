package shape;


import drawing.*;

import java.lang.annotation.ElementType;

public class CSquare extends CShape {

    private final ElementType SQUARE=null;
    private int HS_HORIZONTAL;
    private int HS_DIAGCROSS;
    private int width;



    @Override
    public void Draw(CDC pDC) {
        CPen pen=new CPen(), pOldPen;
        pen.CreatePen(BorderType, BorderWidth, BorderColor);			//画笔样式  画笔的线宽  画笔颜色
        pOldPen = (CPen)pDC.SelectObject(pen);						//保存原来画笔
        CBrush brush=new CBrush(),pOldBrush;										//创建画刷  进行颜色填充
        if (FillType >= HS_HORIZONTAL && FillType <= HS_DIAGCROSS)
            brush.CreateHatchBrush(FillType, FillColor);				//创建阴影画刷
        else
            brush.CreateSolidBrush(FillColor);							//创建图案画刷
        pOldBrush = (CBrush)pDC.SelectObject(brush);					//保存原来画刷

        pDC.Rectangle(OrgX - width / 2.0, OrgY - width / 2.0, OrgX + width / 2.0, OrgY + width / 2.0);


        pDC.SelectObject(pOldPen);										//恢复画笔
        //pDC->SelectObject(pOldBrush);
    }



    ;
    public	CSquare(int x, int y, int w) {
        Type = SQUARE;
        OrgX = x;
        OrgY = y;
        width = w;
    }

    @Override
    public boolean IsMatched(CPoint pnt) {
        if (pnt.x >= (OrgX - width / 2.0) && pnt.y >= (OrgY - width / 2.0) && pnt.y <= (OrgY + width / 2.0) && pnt.x <= (OrgX + width / 2.0))
            return true;
        else
            return false;
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
//            ar << width;		//正方形边长
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
//            ar >> width;		//正方形边长
        }
    }
    public	void SetValue(int x, int y, int w_r, int h, String s){
        OrgX = x;
        OrgY = y;
        width = w_r;
    };
    public	void GetValue(int type, int x, int y, int w_r , int h, String s){
        type = 0;
        x = OrgX;
        y = OrgY;
        w_r = width;
    };


}
