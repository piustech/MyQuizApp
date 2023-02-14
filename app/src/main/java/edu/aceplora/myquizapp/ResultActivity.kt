package edu.aceplora.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvScore: TextView = findViewById(R.id.tv_score)
        val btnFinish: Button = findViewById(R.id.btn_finish)

        tvName.text = intent.extras?.getString(Constants.USER_NAME)

        val totalQuestions = intent.extras?.getInt(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.extras?.getInt(Constants.CORRECT_ANSWERS, 0)

        tvScore.text = getString(R.string.score, correctAnswers.toString(), totalQuestions.toString())

        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}