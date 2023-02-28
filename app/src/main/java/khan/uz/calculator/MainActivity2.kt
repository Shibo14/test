package khan.uz.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import khan.uz.calculator.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener{

            val name = binding.txt.text.toString()

            if (name.isEmpty()){
                binding.txt.error = "error"
                return@setOnClickListener
            }


        }






    }
}