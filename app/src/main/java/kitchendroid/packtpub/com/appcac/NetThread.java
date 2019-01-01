package kitchendroid.packtpub.com.appcac;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.lang.Runnable;

import android.util.Log;
import android.os.Looper;

public class NetThread extends Thread {

    private Context context;
    private static Socket socket = null;
    private BufferedReader in = null;
    private static PrintWriter ou = null;
    private boolean remoteExit;
    private String targetHost;
    private int targetPort;
    public NetThread netThread;


    NetThread(String host, int port, Context mContext) {
        this.targetHost = host;
        this.targetPort = port;
        this.context = mContext;
    }

    public static void sendToServer(String s) {
        if (socket != null && s != null)
            ou.println(s);
    }

    public void run() {

        String message = "";
        char qCategory;
        int parseMark;
        int qIndex;
        int value;

        try {
            System.out.println("Weer bij Run");
            Settings settings = new Settings(MainActivity.context);
            settings.loadPref();

            socket = new Socket(settings.host, settings.port);
            ou = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (UnknownHostException e) {
            System.out.println("Oeps, UnknownHostException");
            System.out.println(e);

        } catch (IOException e) {
            System.out.println("Oeps, IOException");
            System.out.println(e);
        }

        while (true)
            if (MainActivity.reloadPrefs || MainActivity.restartNetThread) {

                MainActivity.reloadPrefs = false;
                Settings settings = new Settings(MainActivity.context);
                settings.loadPref();

                if (MainActivity.restartNetThread) {

                    try {
                        ou.println("exit");
                        MainActivity.restartNetThread = false;
                        socket = new Socket(settings.host, settings.port);
                        ou = new PrintWriter(socket.getOutputStream(), true);
                        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        ou.println("bang");
                    } catch (UnknownHostException e) {
                        System.out.println("Oeps, foutje");
                        System.out.println(e);

                    } catch (IOException e) {
                        System.out.println("Oeps, foutje nr 2");
                        System.out.println(e);
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                } else
                    try {
                        if ((message = in.readLine()) != null) {

                                if (message.charAt(0) == 'Q') {
                                    parseMark = message.indexOf('=');

                                        qCategory = message.charAt(1);
                                        qIndex = Integer.parseInt(message.substring(2, parseMark));
                                        parseMark++;

                                        if (qCategory == 's') {

                                        } else if (qCategory == 'i') {
                                            if (qIndex == 98) {
                                                if (Integer.parseInt(message.substring(parseMark, message.length())) > 0) {
                                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            if (MainActivity.intArray[0] == 1) {
                                                                MainActivity.button1.setBackgroundResource(R.drawable.miconwhitecallonorange);
                                                            } else
                                                                MainActivity.button1.setBackgroundResource(R.drawable.micoffcallonorange);
                                                        }
                                                    });
                                                }
                                            }
                                            if (qIndex == 99) {
                                                if (Integer.parseInt(message.substring(parseMark, message.length())) > 0) {
                                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            if (MainActivity.intArray[1] == 1) {
                                                                MainActivity.button2.setBackgroundResource(R.drawable.miconwhitecallonorange);
                                                            } else
                                                                MainActivity.button2.setBackgroundResource(R.drawable.micoffcallonorange);
                                                        }
                                                    });
                                                }
                                            }
                                            if (qIndex == 100) {
                                                if (Integer.parseInt(message.substring(parseMark, message.length())) > 0) {
                                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            if (MainActivity.intArray[2] == 1) {
                                                                MainActivity.button3.setBackgroundResource(R.drawable.miconwhitecallonorange);
                                                            } else
                                                                MainActivity.button3.setBackgroundResource(R.drawable.micoffcallonorange);
                                                        }
                                                    });
                                                }
                                            }
                                            if (qIndex == 101) {
                                                if (Integer.parseInt(message.substring(parseMark, message.length())) > 0) {
                                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            if (MainActivity.intArray[4] == 1) {
                                                                MainActivity.button5.setBackgroundResource(R.drawable.miconwhitecallonorange);
                                                            } else
                                                                MainActivity.button5.setBackgroundResource(R.drawable.micoffcallonorange);
                                                        }
                                                    });
                                                }
                                            }
                                            if (qIndex == 102) {
                                                if (Integer.parseInt(message.substring(parseMark, message.length())) > 0) {
                                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            if (MainActivity.intArray[5] == 1) {
                                                                MainActivity.button6.setBackgroundResource(R.drawable.miconwhitecallonorange);
                                                            } else
                                                                MainActivity.button6.setBackgroundResource(R.drawable.micoffcallonorange);
                                                        }
                                                    });
                                                }
                                            }
                                            if (qIndex == 103) {
                                                if (Integer.parseInt(message.substring(parseMark, message.length())) > 0) {
                                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            if (MainActivity.intArray[6] == 1) {
                                                                MainActivity.button7.setBackgroundResource(R.drawable.miconwhitecallonorange);
                                                            } else
                                                                MainActivity.button7.setBackgroundResource(R.drawable.micoffcallonorange);
                                                        }
                                                    });
                                                }
                                            }
                                            if (qIndex == 104) {
                                                if (Integer.parseInt(message.substring(parseMark, message.length())) > 0) {
                                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            if (MainActivity.intArray[7] == 1) {
                                                                MainActivity.button8.setBackgroundResource(R.drawable.miconwhitecallonorange);
                                                            } else
                                                                MainActivity.button8.setBackgroundResource(R.drawable.micoffcallonorange);
                                                        }
                                                    });
                                                }
                                            }
                                            if (qIndex == 106) {
                                                MainActivity.ReceiverSelL = Integer.parseInt(message.substring(parseMark, message.length()));
                                                MainActivity.ledNr = 0;

                                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Log.d("UI thread", "I am the UI thread: ");
                                                        while (MainActivity.ledNr < 13) {
                                                            Log.d("UI thread", "I am lednr: " + MainActivity.ledNr);
                                                            if ((MainActivity.ReceiverSelL % 2) == 1) {
                                                                MainActivity.intArray[MainActivity.ledNr] = 1;
                                                                switch (MainActivity.ledNr) {
                                                                    case 0:
                                                                        MainActivity.led1.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                    case 1:
                                                                        MainActivity.led2.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                    case 2:
                                                                        MainActivity.led3.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                    case 3:
                                                                        MainActivity.led4.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                    case 4:
                                                                        MainActivity.led5.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                    case 5:
                                                                        MainActivity.led6.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                    case 6:
                                                                        MainActivity.led7.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                    case 7:
                                                                        MainActivity.led8.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                    case 8:
                                                                        //MainActivity.led9.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                    case 9:
                                                                        //MainActivity.led10.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                    case 10:
                                                                        MainActivity.led9.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                    case 11:
                                                                        MainActivity.led10.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                    case 12:
                                                                        MainActivity.led11.setBackgroundResource(R.drawable.ledon);
                                                                        break;
                                                                }
                                                            } else {
                                                                MainActivity.intArray[MainActivity.ledNr] = 0;
                                                                switch (MainActivity.ledNr) {
                                                                    case 0:
                                                                        MainActivity.led1.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                    case 1:
                                                                        MainActivity.led2.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                    case 2:
                                                                        MainActivity.led3.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                    case 3:
                                                                        MainActivity.led4.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                    case 4:
                                                                        MainActivity.led5.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                    case 5:
                                                                        MainActivity.led6.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                    case 6:
                                                                        MainActivity.led7.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                    case 7:
                                                                        MainActivity.led8.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                    case 8:
                                                                        //MainActivity.led9.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                    case 9:
                                                                        //MainActivity.led10.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                    case 10:
                                                                        MainActivity.led9.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                    case 11:
                                                                        MainActivity.led10.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                    case 12:
                                                                        MainActivity.led11.setBackgroundResource(R.drawable.ledoff);
                                                                        break;
                                                                }
                                                            }

                                                            MainActivity.ledNr += 1;
                                                            MainActivity.ReceiverSelL /= 2;
                                                        }
                                                    }
                                                });
                                            }
                                            if (qIndex == 109) {
                                                MainActivity.SwitchesAudioL = Integer.parseInt(message.substring(parseMark, message.length()));

                                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Log.d("UI thread", "I am the UI thread");
                                                        MainActivity.button1.setBackgroundResource(R.drawable.micoffcalloff);
                                                        MainActivity.button2.setBackgroundResource(R.drawable.micoffcalloff);
                                                        MainActivity.button3.setBackgroundResource(R.drawable.micoffcalloff);
                                                        MainActivity.button4.setBackgroundResource(R.drawable.micoffcalloff);
                                                        MainActivity.button5.setBackgroundResource(R.drawable.micoffcalloff);
                                                        MainActivity.button6.setBackgroundResource(R.drawable.micoffcalloff);
                                                        MainActivity.button7.setBackgroundResource(R.drawable.micoffcalloff);
                                                        MainActivity.button8.setBackgroundResource(R.drawable.micoffcalloff);
                                                        MainActivity.button9.setBackgroundResource(R.drawable.micoffcalloff);
                                                        MainActivity.button10.setBackgroundResource(R.drawable.micoffcalloff);

                                                        switch (MainActivity.SwitchesAudioL) {
                                                            case 0:
                                                                MainActivity.button1.setVisibility(View.VISIBLE);
                                                                MainActivity.button1.setBackgroundResource(R.drawable.miconwhitecalloff);
                                                                break;
                                                            case 1:
                                                                MainActivity.button2.setVisibility(View.VISIBLE);
                                                                MainActivity.button2.setBackgroundResource(R.drawable.miconwhitecalloff);
                                                                break;
                                                            case 2:
                                                                MainActivity.button3.setVisibility(View.VISIBLE);
                                                                MainActivity.button3.setBackgroundResource(R.drawable.miconwhitecalloff);
                                                                break;
                                                            case 3:
                                                                MainActivity.button4.setVisibility(View.VISIBLE);
                                                                MainActivity.button4.setBackgroundResource(R.drawable.miconwhitecalloff);
                                                                break;
                                                            case 4:
                                                                MainActivity.button5.setVisibility(View.VISIBLE);
                                                                MainActivity.button5.setBackgroundResource(R.drawable.miconwhitecalloff);
                                                                break;
                                                            case 5:
                                                                MainActivity.button6.setVisibility(View.VISIBLE);
                                                                MainActivity.button6.setBackgroundResource(R.drawable.miconwhitecalloff);
                                                                break;
                                                            case 6:
                                                                MainActivity.button7.setVisibility(View.VISIBLE);
                                                                MainActivity.button7.setBackgroundResource(R.drawable.miconwhitecalloff);
                                                                break;
                                                            case 7:
                                                                MainActivity.button8.setVisibility(View.VISIBLE);
                                                                MainActivity.button8.setBackgroundResource(R.drawable.miconwhitecalloff);
                                                                break;
                                                            case 8:
                                                                MainActivity.button9.setVisibility(View.VISIBLE);
                                                                MainActivity.button9.setBackgroundResource(R.drawable.miconwhitecalloff);
                                                                break;
                                                            case 9:
                                                                MainActivity.button10.setVisibility(View.VISIBLE);
                                                                MainActivity.button10.setBackgroundResource(R.drawable.miconwhitecalloff);
                                                                break;
                                                        }
                                                    }
                                                });
                                            }
                                        } else if (qCategory == 'h') {
                                            // Some code to handle Qh...
                                        }


                                } else if (message.charAt(0) == 'L') {


                                } else if (message.substring(0, 3).equals("id=")) {

                                    try {
                                        System.out.println("Connection OK. Our client id: " + message);
                                        MainActivity.id = message;
                                    } catch (NumberFormatException nfe) {
                                        nfe.printStackTrace();
                                    }

                                } else if (message.length() > 8
                                        && message.substring(0, 8).equals("version=")) {
                                    MainActivity.version = message;
                                } else if (message.equals("load1")) {
                                    // Situation loading phase 1 (paused and reading variables)
                                } else if (message.equals("load2")) {
                                    // Situation loading phase 2 (reading model options)
                                } else if (message.equals("load3")) {
                                    // Situation loading phase 3 (unpaused)
                                } else if (message.equals("exit")) {
                                    remoteExit = true;
                                    break;
                                } else if (message.startsWith("metar=")) {
                                    // METAR feeder status message
                                }

                            }
                    } catch (NullPointerException e) {
                        System.out.print("NullPointerException caught");
                    } catch (IOException e) {
                        System.out.println("Bam, een fout");
                        System.out.println(e);
                    }
            }
    }

    void finalJobs() {
        try {
            if (!remoteExit && ou != null) {
                ou.println("exit");
                try {
                    java.lang.Thread.sleep(20);
                } catch (InterruptedException e) {
                }
                ou.close();
            }
            if (in != null)
                in.close();
            if (socket != null)
                socket.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}