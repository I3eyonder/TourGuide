package hieupt.tourguidedemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_basic.*
import hieupt.tourguide.Pointer
import hieupt.tourguide.ToolTip
import hieupt.tourguide.TourGuide


class NoOverlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        val tourGuide = TourGuide.init(this).playOn(button1) {
            setPointer(Pointer().apply {
                technique = Pointer.Technique.CLICK
            }) // set pointer to null
            setToolTip(ToolTip().setTitle("Welcome :)").setDescription("Have a nice and fun day!"))
        }.show()

        button1.setOnClickListener { tourGuide.cleanUp() }
        button2.setOnClickListener {
            tourGuide.playOn(button1) {
                setPointer(Pointer().apply {
                    technique = Pointer.Technique.CLICK
                })  // set pointer to null
                setToolTip(ToolTip().setTitle("Welcome :)").setDescription("Have a nice and fun day!"))
            }.show()
        }
    }
}
