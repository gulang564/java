package shape;

import drawing.CArchive;
import drawing.CDC;
import drawing.COLORREF;
import drawing.CPoint;

import java.lang.annotation.ElementType;

public abstract class CShape
{
    public CShape(){};

    public	abstract void Draw(CDC pDC);			//绘制图元

    public	abstract boolean IsMatched(CPoint pnt);	//点是否落在图形内部

    public	abstract void Serialize(CArchive ar);

    public void SetPen(COLORREF penColor, int penType, int penWidth, int PS_SOLID) {
        //默认：黑色水笔
        if (penColor == null) {

           penColor.byBlue=0;
           penColor.byGreen=0;
           penColor.byRed=0;

            penType = PS_SOLID;
            penWidth = 1;
        }
        BorderColor = penColor;
        BorderType = penType;
        BorderWidth = penWidth;

    };

    public	void SetBrush(COLORREF fillColor, int fillType, int HS_DIAGCROSS){
        //默认：蓝色水刷
        if(fillColor==null){


            fillColor.byRed=0;
            fillColor.byGreen=0;
            fillColor.byBlue=255;

            fillType = HS_DIAGCROSS + 1;
        }

        FillColor = fillColor;
        FillType = fillType;
    };

    public  void GetPen(COLORREF penColor, int penType, int penWidth){
        penColor = BorderColor;
        penType = BorderType;
        penWidth = BorderWidth;

    };
    public	void GetBrush(COLORREF fillColor, int fillType){
        fillColor = FillColor;
        fillType = FillType;

    };

    public 	void SetValue(int x, int y, int w_r, int h, String s){

    };
    public	void GetValue(int type, int x, int y, int w_r , int h, String s){

    };


    protected ElementType Type;			//图元类型
    protected	int OrgX;					//原点坐标
    protected	int OrgY;
    protected	COLORREF   BorderColor;		//边界颜色
    protected	int BorderType;				//边界线型--实线、虚线、虚点线等
    protected	int BorderWidth;			//边界宽度
    protected	COLORREF  FillColor;		//填充颜色
    protected	int FillType;				//填充类型--实心、双对角、十字交叉等
};

