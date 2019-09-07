package shape;

import drawing.*;

import java.lang.annotation.ElementType;

public class CCircle extends CShape {

    private int HS_HORIZONTAL;
    private int HS_DIAGCROSS;
    private final ElementType CIRCLE=null;

    public	CCircle(){};
    public	CCircle(int x, int y, int r) {
        Type = CIRCLE;
        OrgX = x;
        OrgY = y;
        radius = r;
    }
    
    @Override
    public void Draw(CDC pDC) {
        CPen pen=new CPen(), pOldPen;
        pen.CreatePen(BorderType, BorderWidth, BorderColor);			//画笔样式  画笔的线宽  画笔颜色
        pOldPen = (CPen)pDC.SelectObject(pen);						//保存原来画笔
        CBrush brush=new CBrush(), pOldBrush;										//创建画刷  进行颜色填充
        if (FillType >= HS_HORIZONTAL && FillType <= HS_DIAGCROSS)
            brush.CreateHatchBrush(FillType, FillColor);				//创建阴影画刷
        else
            brush.CreateSolidBrush(FillColor);							//创建图案画刷
        pOldBrush = (CBrush)pDC.SelectObject(brush);					//保存原来画刷

        pDC.Ellipse(OrgX - radius, OrgY - radius, OrgX + radius, OrgY + radius);


        pDC.SelectObject(pOldPen);										//恢复画笔
        pDC.SelectObject(pOldBrush);
    }

    @Override
    public boolean IsMatched(CPoint pnt) {
        return false;
    }

    @Override
    public void Serialize(CArchive ar) {

    }
    public	void SetValue(int x, int y, int w_r,  int h, String s){
        OrgX = x;
        OrgY = y;
        radius = w_r;
    };
    public	void GetValue(int type, int x, int y, int w_r,  int h, String s){
        type = 2;
        x = OrgX;
        y = OrgY;
        w_r = radius;
    };

    private	int radius;//半径
}
