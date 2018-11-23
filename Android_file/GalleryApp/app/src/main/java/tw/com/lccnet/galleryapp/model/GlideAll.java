package tw.com.lccnet.galleryapp.model;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;
import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.Utils;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;
import static com.bumptech.glide.request.RequestOptions.overrideOf;

public class GlideAll {
    //private List<Type> dataSet;
   private static Context context;
 //   private static Glide ss=Glide.with(context).load(img);
    public GlideAll(Context context) {
        this.context = context;
    }

 /*   enum Type {
        Mask,
        NinePatchMask,
        CropTop,
        CropCenter,
        CropBottom,
        CropSquare,
        CropCircle,
        ColorFilter,
        Grayscale,
        RoundedCorners,
        Blur,
        SupportRSBlur,
        Toon,
        Sepia,
        Contrast,
        Invert,
        Pixel,
        Sketch,
        Swirl,
        Brightness,
        Kuawahara,
        Vignette
    }
*/
    public static void setMask(Object img, ImageView iv){
        int width = Utils.dip2px(context, 266.66f);
        int height = Utils.dip2px(context, 252.66f);
        Glide.with(context)
                .load(img)
                .apply(overrideOf(width, height))
                .apply(bitmapTransform(new MultiTransformation<>(new CenterCrop(),
                        new MaskTransformation(R.drawable.mask_starfish))))
                .into(iv);
    }
    public static void setNinePatchMask(Object img, ImageView iv){
        int width = Utils.dip2px(context, 300.0f);
        int height = Utils.dip2px(context, 200.0f);
        Glide.with(context)
                .load(img)
                .apply(overrideOf(width, height))
                .apply(bitmapTransform(new MultiTransformation<>(new CenterCrop(),
                        new MaskTransformation(R.drawable.mask_chat_right))))
                .into(iv);
    }
    public static void setCropTop(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(
                        new CropTransformation(Utils.dip2px(context, 300), Utils.dip2px(context, 100),
                                CropTransformation.CropType.TOP)))
                .into(iv);
    }
    public static void setCropCenter(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(
                        new CropTransformation(Utils.dip2px(context, 300), Utils.dip2px(context, 100), CropTransformation.CropType.CENTER)))
                .into(iv);
    }
    public static void setCropBottom(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(
                        new CropTransformation(Utils.dip2px(context, 300), Utils.dip2px(context, 100),
                                CropTransformation.CropType.BOTTOM)))
                .into(iv);
    }
    public static void setCropSquare(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new CropSquareTransformation()))
                .into(iv);
    }
    public static void setCropCircle(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new CropCircleTransformation()))
                .into(iv);
    }
    public static void setColorFilter(Object img, ImageView iv) {
        //Color.argb(80, 255, 0, 0)

        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new ColorFilterTransformation(Color.argb(80, 255, 0, 0))))
                .into(iv);
    }
    public static void setGrayscale(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new GrayscaleTransformation()))
                .into(iv);
    }

    public static void setRoundedCorners(Object img, ImageView iv) {
        //new RoundedCornersTransformation(45, 0,
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new RoundedCornersTransformation(45, 0,
                        RoundedCornersTransformation.CornerType.BOTTOM)))
                .into(iv);
    }
    public static void setBlur(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new BlurTransformation(25)))
                .into(iv);

    }
//此方法無法使用
/*    public static void setSupportRSBlur(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new SupportRSBlurTransformation(25, 10)))
                .into(iv);

    }*/

    public static void setToon(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new ToonFilterTransformation()))
                .into(iv);

    }

    public static void setSepia(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new SepiaFilterTransformation()))
                .into(iv);

    }


    public static void setContrast(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new ContrastFilterTransformation(2.0f)))
                .into(iv);

    }

    public static void setInvert(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new InvertFilterTransformation()))
                .into(iv);

    }

    public static void setPixel(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new PixelationFilterTransformation(20)))
                .into(iv);

    }

    public static void setSketch(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new SketchFilterTransformation()))
                .into(iv);
    }

    public static void setSwirl(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(
                        new SwirlFilterTransformation(0.5f, 1.0f, new PointF(0.5f, 0.5f))).dontAnimate())
                .into(iv);
    }

    public static void setBrightness(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new BrightnessFilterTransformation(0.5f)).dontAnimate())
                .into(iv);
    }

    public static void setKuawahara(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new KuwaharaFilterTransformation(25)).dontAnimate())
                .into(iv);
    }

    public static void setVignette(Object img, ImageView iv) {
        Glide.with(context)
                .load(img)
                .apply(bitmapTransform(new VignetteFilterTransformation(new PointF(0.5f, 0.5f),
                        new float[] { 0.0f, 0.0f, 0.0f }, 0f, 0.75f)).dontAnimate())
                .into(iv);
    }
}



