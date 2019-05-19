package hieupt.tourguidedemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_basic.*
import hieupt.tourguide.TourGuide


class NoPointerNoToolTipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
        val tourGuide = TourGuide.create(this) {
            overlay {}
        }.playOn(button1).show()

        button1.setOnClickListener { tourGuide.cleanUp() }
        button2.setOnClickListener { tourGuide.playOn(button1).show() }
    }
}
