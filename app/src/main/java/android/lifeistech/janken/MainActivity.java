package android.lifeistech.janken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // CPUの手を表示するImageViewと結びつける変数
    ImageView cpu;
    // プレイヤーの手を表示するImageViewと結びつける変数
    ImageView player;
    // 結果を表示するTextViewと結びつける変数
    TextView result;
    // 乱数を生成する変数
    Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // それぞれをレイアウト上の要素と結びつける
        cpu = findViewById(R.id.cpu);
        player = findViewById(R.id.player);
        result = findViewById(R.id.result);
    }

    // プレイヤーがグーを選択した時の処理
    public void gu(View v){
        // プレイヤー側の画像をグーに変更
        player.setImageResource(R.drawable.gu);
        // CPUの手を決める乱数を生成
        int r = rnd.nextInt(3);

        // 乱数が0のとき
        if(r == 0){
            // CPUの手をグーとして設定
            cpu.setImageResource(R.drawable.gu);
            // 勝ち負けをTextViewに表示
            result.setText("引き分けです");
        // 乱数が0でなく1のとき
        }else if(r == 1){
            // CPuの手をチョキとして設定
            cpu.setImageResource(R.drawable.ch);
            // 勝ち負けをTextViewに表示
            result.setText("あなたの勝ちです");
        // 乱数が0でなく1でなく2のとき
        }else if(r == 2){
            // CPUの手をパーとして設定
            cpu.setImageResource(R.drawable.pa);
            // 勝ち負けをTextViewに表示
            result.setText("あなたの負けです");
        }
    }

    // 同様にチョキ，パーを選択した時の処理

    public void ch(View v){
        player.setImageResource(R.drawable.ch);
        int r = rnd.nextInt(3);

        if(r == 0){
            cpu.setImageResource(R.drawable.gu);
            result.setText("あなたの負けです");
        }else if(r == 1){
            cpu.setImageResource(R.drawable.ch);
            result.setText("引き分けです");
        }else if(r == 2){
            cpu.setImageResource(R.drawable.pa);
            result.setText("あなたの勝ちです");
        }
    }

    public void pa(View v){
        player.setImageResource(R.drawable.pa);
        int r = rnd.nextInt(3);

        if(r == 0){
            cpu.setImageResource(R.drawable.gu);
            result.setText("あなたの勝ちです");
        }else if(r == 1){
            cpu.setImageResource(R.drawable.ch);
            result.setText("あなたの負けです");
        }else if(r == 2){
            cpu.setImageResource(R.drawable.pa);
            result.setText("引き分けです");
        }
    }
}
