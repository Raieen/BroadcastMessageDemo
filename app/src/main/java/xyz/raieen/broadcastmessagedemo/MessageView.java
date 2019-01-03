package xyz.raieen.broadcastmessagedemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class MessageView extends LinearLayout {

    private String message;
    private long sent;

    public MessageView(Context context) {
        super(context);
        init(context);
    }

    public MessageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MessageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public MessageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        // Inflate
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.layout_message, this, true);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

        TextView textMessage = findViewById(R.id.text_message);
        textMessage.setText(message);
    }

    public long getSent() {
        return sent;
    }

    public void setSent(long sent) {
        this.sent = sent;
        TextView textTimestamp = findViewById(R.id.text_timestamp);
        textTimestamp.setText(new Date(sent).toString());
    }
}
