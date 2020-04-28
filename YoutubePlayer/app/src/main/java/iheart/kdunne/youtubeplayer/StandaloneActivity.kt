package iheart.kdunne.youtubeplayer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_standalone.*
import java.lang.IllegalArgumentException

class StandaloneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)

        val listener = View.OnClickListener {
            val intent = when (it.id) {
                R.id.btnPlayVideo -> YouTubeStandalonePlayer.createVideoIntent(
                        this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_ID, 0, true, false
                )
                R.id.btnPlaylist -> YouTubeStandalonePlayer.createPlaylistIntent(
                        this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_PLAYLIST, 0, 0, true, true
                )
                else -> throw IllegalArgumentException("Undefined button clicked")
            }
            startActivity(intent)
        }
        btnPlayVideo.setOnClickListener(listener)
        btnPlaylist.setOnClickListener(listener)
    }
}