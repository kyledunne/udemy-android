package iheart.kdunne.youtubeplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener = View.OnClickListener {
            val intent = when (it.id) {
                R.id.btnPlaySingle -> Intent(this, YoutubeActivity::class.java)
                R.id.btnStandalone -> Intent(this, StandaloneActivity::class.java)
                else -> throw IllegalArgumentException("Undefined button clicked")
            }
            startActivity(intent)
        }
        btnPlaySingle.setOnClickListener(listener)
        btnStandalone.setOnClickListener(listener)
    }
}
