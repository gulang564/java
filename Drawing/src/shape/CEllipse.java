package shape;

import drawing.*;

import java.lang.annotation.ElementType;

import static java.lang.Math.pow;

public class CEllipse extends CShape {
    private final Object ELLIPSE=null;
    private int HS_HORIZONTAL;
    private int HS_DIAGCROSS;
    public	CEllipse(){}

    @Override
    public void Draw(CDC pDC) {
        CPen pen=new CPen(),pOldPen;
        pen.CreatePen(BorderType, BorderWidth, BorderColor);			//画笔样式  画笔的线宽  画笔颜色
        pOldPen = (CPen)pDC.SelectObject(pen);						//保存原来画笔
        CBrush brush=new CBrush(),pOldBrush;										//创建画刷  进行颜色填充
        if (FillType >= HS_HORIZONTAL && FillType <= HS_DIAGCROSS)
            brush.CreateHatchBrush(FillType, FillColor);				//创建阴影画刷
        else
            brush.CreateSolidBrush(FillColor);							//创建图案画刷
        pOldBrush = (CBrush)pDC.SelectObject(brush);					//保存原来画刷

        pDC.Ellipse(OrgX - width / 2.0, OrgY - height / 2.0, OrgX + width / 2.0, OrgY + height / 2.0);


        pDC.SelectObject(pOldPen);										//恢复画笔
        pDC.SelectObject(pOldBrush);
    }

    @Override
    public boolean IsMatched(CPoint pnt) {
        if ((pow((pnt.x - OrgX), 2) / pow((width / 2.0), 2) + pow((pnt.y - OrgY), 2) / pow((height / 2.0), 2)) <= 1)
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
//            ar << width;		//椭圆的长轴
//            ar << height;		//椭圆的短轴
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
//            ar >> width;		//椭圆的长轴
//            ar >> height;		//椭圆的短轴
        }


    }

    ;
    public	CEllipse(int x, int y, int w, int h){
        Type = (ElementType) ELLIPSE;
        OrgX = x;
        OrgY = y;
        width = w;
        height = h;

    }
    public	void SetValue(int x, int y, int w_r,  int h, String s){
        OrgX = x;
        OrgY = y;
        width = w_r;
        height = h;
    };
    public	void GetValue(int type, int x, int y, int w_r,  int h, String s){
        type = 3;
        x = OrgX;
        y = OrgY;
        w_r = width;
        h = height;
    };


    private	int width;      //长半轴短半轴
    private	int height;
}
