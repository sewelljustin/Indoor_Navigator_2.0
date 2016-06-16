package com.usfreu2016.indoornavigator20;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class FloorPlanView  extends View {

    private static final String TAG = "FloorPlanView";

    /** Constants for colors of paint objects */
    private final int mCircle1Color = Color.BLUE;
    private final int mCircle2Color = Color.GREEN;

    /** variable for radius of circles that represent the position of the mobile device */
    private int mRadius;

    /** References to screen width and height */
    private int mScreenWidth;
    private int mScreenHeight;

    /** Variables for the coordinates of each circle that represent the position of the mobile device */
    private int mCircle1X;
    private int mCircle1Y;
    private int mCircle2X;
    private int mCircle2Y;

    /** Paint objects for circles that represent the position of the mobile device */
    private Paint mCircle1Paint;
    private Paint mCircle2Paint;

    public FloorPlanView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //Log.d(TAG, "constructed");

        /** create new paint objects for circles */
        mCircle1Paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCircle2Paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        /** Set Paint objects colors */
        mCircle1Paint.setColor(mCircle1Color);
        mCircle2Paint.setColor(mCircle2Color);
    } // end Constructor

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Log.d(TAG, "onDraw");

        canvas.drawCircle(mCircle1X, mCircle1Y, mRadius, mCircle1Paint);
        canvas.drawCircle(mCircle2X, mCircle2Y, mRadius, mCircle2Paint);

    } // end onDraw

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //Log.d(TAG, "onSizeChanged");

        mScreenWidth = w;
        mScreenHeight = h;

        /** Calculate radius of circles based on screen width; value was determined by testing */
        mRadius = (int) (0.01f * w);

        /** Calculate the x value for each circle that represent the position of the mobile device
         *  Initial start point of each position will be the middle cell of the model */
        mCircle1X = mScreenWidth / 2;
        mCircle2X = mScreenWidth / 2;

        /** Calculate the y value for each circle that represent the position of the mobile device */
        mCircle1Y = mScreenHeight / 2;
        mCircle2Y = (mScreenHeight * 3) / 5;

    } // end onSizeChanged

}
