package aplicacao.mobilie.maps.itraxx


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.VideoView
import androidx.fragment.app.Fragment



class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflar o layout do fragmento
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val videoView = view.findViewById<VideoView>(R.id.video)
        val videoPath =
            "android.resource://" + requireActivity().packageName + "/" + R.raw.login_fundo
        val uri = Uri.parse(videoPath)
        videoView.setVideoURI(uri)

        // Visualizador do vídeo
        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
            videoView.start()
        }

        val loginButton = view.findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            // Navegue para o ScannerFragment
            val scannerFragment = ScannerFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.telaLogin, scannerFragment)
                .commit()

            // Finalize o LoginFragment
            requireActivity().supportFragmentManager.beginTransaction()
                .remove(this)
                .commit()

        }

        return view
    }
}