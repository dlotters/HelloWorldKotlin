package net.lotters.helloworldkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import net.lotters.helloworldkotlin.R.string.strWelcome

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationY = txtWelcome.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p1>0) {
                    txtWelcome.text = p1.toString()
                }
                else {
                    txtWelcome.text = resources.getString(strWelcome)
                }

                val translationDistance = (initialTextViewTranslationY + p1 * resources.getDimension(R.dimen.text_anim_step) * -1)
                txtWelcome.animate().translationY(translationDistance)
                if (!p2) {
                    txtWelcome.animate().setDuration(500).rotationBy(360f)
                            .translationY(initialTextViewTranslationY)
                }

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }


        })

        btnReset.setOnClickListener( {
            seekBar.progress = 0

        })

    }
}
