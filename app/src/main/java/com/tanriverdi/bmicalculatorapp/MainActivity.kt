package com.tanriverdi.bmicalculatorapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.tanriverdi.bmicalculatorapp.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        clickListener()
    }

    //Is the method of the reset button
    private fun resetFields(){
        binding.weightEdit.text.clear()
        binding.heightEdit.text.clear()
        binding.radioGroupGender.clearCheck()
        binding.resultText.text=resources.getText(R.string.result)
        binding.resultText.setTextColor(Color.BLACK)

    }

    /*The method that allows us to determine which part of the
     radio button is selected and take action accordingly.*/
    private fun handleGenderSelection(){
        val radioGroupGender=binding.radioGroupGender
        val selectedGenderId:Int=radioGroupGender.checkedRadioButtonId


        if(selectedGenderId==-1){
            Toast.makeText(this,resources.getString(R.string.chooseGender), Toast.LENGTH_SHORT).show()
            return
        }


        val radioButtonGender: RadioButton =findViewById(selectedGenderId)
        val selectedGender:String=radioButtonGender.text.toString()


        if (selectedGender.equals(resources.getString(R.string.male), ignoreCase = true)){

            calculateBMIMale()

        }else{

            calculateBMIFemale()
        }

    }

    //BMI calculates by gender
    private fun calculateBMIFemale(){

        val weight=binding.weightEdit.text.toString().toFloatOrNull()
        val height=binding.heightEdit.text.toString().toFloatOrNull()

        if (weight!=null && height!=null) {
            val bmi = weight / (height / 100).pow(2)
            val bmiResult = String.format("%2f", bmi)

            val bmiCategory = when {
                bmi < 18.5 -> {
                    binding.resultText.setTextColor(Color.GRAY)
                    resources.getString(R.string.underWeight)
                }

                bmi < 24.9-> {
                    binding.resultText.setTextColor(Color.GREEN)
                    resources.getString(R.string.normalWeight)                }

                bmi < 29.9 -> {
                    binding.resultText.setTextColor(Color.MAGENTA)
                    resources.getString(R.string.overWeight)
                }

                else -> {
                    binding.resultText.setTextColor(Color.RED)
                    resources.getString(R.string.obese)
                }

            }

            binding.resultText.text="${resources.getString(R.string.bmi)} $bmiResult \n${resources.getString(R.string.category)} $bmiCategory"

        } else{
            binding.resultText.text=resources.getString(R.string.result)
            binding.resultText.setTextColor(Color.BLACK)
            Toast.makeText(this,resources.getString(R.string.invalid), Toast.LENGTH_SHORT).show()
        }


    }
    private fun calculateBMIMale(){

        val weight=binding.weightEdit.text.toString().toFloatOrNull()
        val height=binding.heightEdit.text.toString().toFloatOrNull()

        if (weight!=null && height!=null) {
            val bmi = weight / (height / 100).pow(2)
            val bmiResult = String.format("%2f", bmi)

            val bmiCategory = when {
                bmi < 20.5 -> {
                    binding.resultText.setTextColor(Color.GRAY)
                    resources.getString(R.string.underWeight)
                }

                bmi < 26.9-> {
                    binding.resultText.setTextColor(Color.GREEN)
                    resources.getString(R.string.normalWeight)                }

                bmi < 31.9-> {
                    binding.resultText.setTextColor(Color.MAGENTA)
                    resources.getString(R.string.overWeight)
                }

                else -> {
                    binding.resultText.setTextColor(Color.RED)
                    resources.getString(R.string.obese)
                }

            }

            binding.resultText.text="${resources.getString(R.string.bmi)} $bmiResult \n${resources.getString(R.string.category)} $bmiCategory"

        } else{
            binding.resultText.text=resources.getString(R.string.result)
            binding.resultText.setTextColor(Color.BLACK)
            Toast.makeText(this,resources.getString(R.string.invalid), Toast.LENGTH_SHORT).show()
        }


    }

    //Method that listens for buttons
    private fun clickListener(){
        binding.calculatorBMI.setOnClickListener{
            handleGenderSelection()
        }
        binding.resetBMI.setOnClickListener {
            resetFields()
        }

    }
}