package aplicacao.mobilie.maps.itraxx


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {//Início do Metodo OnCreate
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val videoView = findViewById<VideoView>(R.id.video_view)//Início comando para inicialização do vídeo da tela de Apresentação
        // Caminho para o vídeo na pasta
        val videoPath = "android.resource://" + packageName + "/" + R.raw.login_fundo
        val uri = Uri.parse(videoPath)
        videoView.setVideoURI(uri)

        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
            videoView.start()

        }


        val imageView = findViewById<ImageView>(R.id.imageView3)
        val textView1 = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)

        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        val fadeInAnimation2 = AnimationUtils.loadAnimation(this, R.anim.fade_out_o)
        val fadeInAnimation1 = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        textView2.startAnimation(fadeInAnimation2)
        textView1.startAnimation(fadeInAnimation)
        imageView.startAnimation(fadeInAnimation1)


        //loadScannerFragment()

    }//Fim no metodo OnCreate


    fun onClickCadastro(view: View) {
        val intent = Intent(this@MainActivity, Branco::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.monitor_tela, R.anim.monitor_tela)
    }


}