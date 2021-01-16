package com.example.test;

/*import androidx.appcompat.app.AppCompatActivity;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;*/

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
//import io.socket.client.IO;

//import static io.socket.client.IO.socket;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity {

    //declare socket object

    private Socket socket;
    private String Nickname ;

    /*{
        try {
            socket = IO.socket("http://192.168.1.65:3000");
        } catch (URISyntaxException e) {}
    }*/


    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {


//if you are using a phone device you should connect to same local network as your laptop and disable your pubic firewall as well

            socket = IO.socket("http://192.168.1.65:3000");

            //create connection
            Log.d(TAG,"ffffffffffffff");
            socket.connect();
            Log.d(TAG," Connected");

// emit the event join along side with the nickname

            //socket.emit('join',Nickname);


        } catch (URISyntaxException e) {
            e.printStackTrace();

        }


        //Nickname= (String)getIntent().getExtras().getString(MainActivity.NICKNAME);

        /*System.out.println("Starting Connection");
        Emitter.Listener onNewMessage = null;
        //mSocket.on("new message", onNewMessage);
        mSocket.connect();
        System.out.println("Connection DONE");*/
    }


    /*public void onClick(View v) {
        MyReceiver myReceiver = new MyReceiver();
        IntentFilter intentFilter = new
                IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(myReceiver, intentFilter);

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Starting Connection");
                    Socket s = new Socket("raspberrypi", 3000);
                    System.out.println("Connection DONE");
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                } catch (UnknownHostException e) {
                    System.out.println("There was an Unknown Erorr:");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.println("There was an IOException:");
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }*/


}