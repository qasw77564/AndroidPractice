package tw.com.lccnet.app.progressbar.customer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Student on 2017/8/20.
 */

public class CustomerProgressBar extends View {
    //畫底線
    private Paint mBackPaint;
    //畫字型
    private Paint mFrontPaint;
    //文字
    private Paint mtextPaint;
    //元件寬度
    private float mstrokeWidth;
    //元件的一半寬度
    private float mHolfStrokeEidth=mstrokeWidth/2;
    //半徑
    private float mRadius=200;
    //建立一個矩形
    private RectF mRect;
    //運行的大小
    private int mProgress=0;

    //可隨需求調整
    private int mTargetProgress=99;
    private int mMax=99;
    private int mWidth;
    private int mHeight;


    public CustomerProgressBar(Context context) {
        super(context);
        init();
    }

    public CustomerProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomerProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        mBackPaint=new Paint();
        mBackPaint.setColor(Color.WHITE);
        mBackPaint.setAntiAlias(true);
        mBackPaint.setStyle(Paint.Style.STROKE);
        mBackPaint.setStrokeWidth(mstrokeWidth);

        mFrontPaint=new Paint();
        mFrontPaint.setColor(Color.BLUE);
        mFrontPaint.setAntiAlias(true);
        mFrontPaint.setStyle(Paint.Style.STROKE);
        mFrontPaint.setStrokeWidth(mstrokeWidth);

        mtextPaint=new Paint();
        mtextPaint.setColor(Color.BLACK);
        mtextPaint.setAntiAlias(true);
        mtextPaint.setTextSize(80);
        mtextPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth=getRealSize(widthMeasureSpec);
        mHeight=getRealSize(heightMeasureSpec);
        setMeasuredDimension(mWidth,mHeight);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        initRect();
        float angle=mProgress/(float)mMax*360;
        canvas.drawCircle(mWidth/2,mHeight/2,mRadius,mBackPaint);
        canvas.drawArc(mRect,-90,angle,false,mFrontPaint);
        canvas.drawText(mProgress+"%",mWidth/2+mHolfStrokeEidth,mHeight/2+mHolfStrokeEidth,mtextPaint);
        if(mProgress<mTargetProgress){
            mProgress+=1;
            invalidate();
        }
    }

    public int getRealSize(int measureSpace){
        int result=1;
        int mode=MeasureSpec.getMode(measureSpace);
        int size=MeasureSpec.getSize(measureSpace);
        if(mode==MeasureSpec.AT_MOST || mode==MeasureSpec.UNSPECIFIED){
            result= (int) (mRadius*2+mstrokeWidth);
        }else {
            result=size;
        }
        return  result;
    }
    public void initRect(){
        if(mRect==null){
            mRect=new RectF();
            int viewSize= (int) (mRadius*2);
            int left=(mWidth-viewSize)/2;
            int top=(mHeight-viewSize)/2;
            int right=left+viewSize;
            int bottom=top+viewSize;
            mRect.set(left,top,right,bottom);
        }
    }
}

