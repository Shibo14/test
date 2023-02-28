package khan.uz.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import khan.uz.calculator.databinding.ActivityMainBinding
import javax.xml.xpath.XPathExpression
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var lastNumber = true
    var stateError = false
    var lastDot = false
    private lateinit var expression: XPathExpression
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Random.nextInt(1,10000)

    }

    fun onDigitClick(view: View) {

        if (view is Button) {
            if (view.text == ".") {
                if (lastNumber) {
                    binding.data.append(view.text)
                    lastNumber = false
                }
            } else {

                binding.data.append(view.text)
                stateError = true
            }
        }

    }

    fun onOperatorClick(view: View) {
        if (view is Button && stateError) {
            binding.data.append(view.text)
            stateError = false
            lastNumber = true
        }
    }

    fun onClearClick(view: View) {

    }

    fun onBackClick(view: View) {
        val length = binding.data.length()

        if (length > 0) {
            binding.data.text = binding.data.text.subSequence(0, length - 1)
        }
    }


    fun onAllClearClick(view: View) {
        binding.data.text = ""
        binding.result.text = ""
    }

    fun onEqualClick(view: View) {

    }

    fun calculatorResults(): String {
        return ""
    }

    fun digitsOperator(): MutableList<Any> {

        val list = mutableListOf<Any>()
        var currentDigit = ""
        for (character in binding.data.text) {

            if (character.isDigit() || character == '.') {
                currentDigit += character
            } else {
                list.add(currentDigit.toFloat())
                currentDigit = ""
                list.add(character)
            }
            
        }


        return list
    }


}