package tw.com.lccnet.app.androidproject.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Student on 2017/8/6.
 * @eric yang
 *  tosee   自訂圓形ImageView(自訂元件)
 *  @author  Eric Yang
 */

@SuppressLint("AppCompatCustomView")
public class XcRoundImageView extends ImageView {
    private Paint paint;
    public XcRoundImageView(Context context) {
        this(context,null);
    }

    public XcRoundImageView(Context context, @Nullable AttributeSet attrs) {
       this(context, attrs,0);
    }

    public XcRoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable=getDrawable();
        if(null != drawable){
            Bitmap bitmap= ((BitmapDrawable) drawable).getBitmap();
            Bitmap b=getCircleBitmap(bitmap,14);
            final Rect rectSrc =new Rect(0,0,b.getWidth(),b.getHeight());
            final Rect rectDes=new Rect(0,0,getWidth(),getHeight());
            paint.reset();
            canvas.drawBitmap(b,rectSrc,rectDes,paint);
        }else {
            super.onDraw(canvas);
        }
    }

    private Bitmap getCircleBitmap(Bitmap bitmap, int i) {
        Bitmap output=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canves=new Canvas(output);

        final int color=0xff424242;

        Rect rect=new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
        paint.setAntiAlias(true);
        canves.drawARGB(0,0,0,0);
        paint.setColor(color);
        int x=bitmap.getWidth();

        canves.drawCircle(x/2,x/2,x/2,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canves.drawBitmap(bitmap,rect,rect,paint);
        return output;
    }
}





















