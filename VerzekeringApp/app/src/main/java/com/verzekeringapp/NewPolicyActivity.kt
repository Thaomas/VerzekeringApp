package com.verzekeringapp

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.verzekeringapp.dao.InsurancePolicyDAO
import com.verzekeringapp.dao.InsurerDAO
import com.verzekeringapp.models.InsurancePolicy
import com.verzekeringapp.models.Insurer

class NewPolicyActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var policyDropdown: Spinner
    private lateinit var descriptionTextView: TextView
    private lateinit var insurerDAO: InsurerDAO
    private lateinit var policyDAO: InsurancePolicyDAO

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_new_policy)

        with(AppDatabase.getDatabase(context = applicationContext)) {
            insurerDAO = insurerDao()
            policyDAO = policyDao()
        }

        val insurers = insurerDAO.getAll()

        val insurerDropdown = findViewById<Spinner>(R.id.insurerDropdown)
        insurerDropdown.onItemSelectedListener = this
        ArrayAdapter<Insurer>(this, android.R.layout.simple_spinner_dropdown_item, insurers)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                insurerDropdown.adapter = adapter
            }

        policyDropdown = findViewById<Spinner>(R.id.policyDropdown)
        policyDropdown.onItemSelectedListener = this


        descriptionTextView = findViewById<TextView>(R.id.policyDescriptionTextView)

    }

    override fun onItemSelected(parentView: AdapterView<*>, view: View, pos: Int, id: Long) {
        when (view.id) {
            R.id.insurerDropdown -> {
                insurerSelected(parentView, view, pos, id)
            }

            R.id.policyDropdown -> {
                policySelected(parentView, view, pos, id)
            }
        }
    }

    private fun insurerSelected(parentView: AdapterView<*>, view: View, pos: Int, id: Long) {
        TODO("Not yet implemented")
        val insurer = parentView.selectedItem as Insurer
        val policies = policyDAO.getAllPoliciesFromInsurer(insurer.uid)
        
        ArrayAdapter<InsurancePolicy>(this, android.R.layout.simple_spinner_dropdown_item, policies)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                policyDropdown.adapter = adapter
                policyDropdown.isEnabled = true
            }

    }

    private fun policySelected(parentView: AdapterView<*>, view: View, pos: Int, id: Long) {
        TODO("Not yet implemented")
        val policy = parentView.selectedItem as InsurancePolicy
        descriptionTextView.text = policy.description

    }

    override fun onNothingSelected(p0: AdapterView<*>) {
        TODO("Not yet implemented")
        when (p0.id) {
            R.id.insurerDropdown -> {
                with(policyDropdown) {
                    isEnabled = false
                    setSelection(0)
                }

                descriptionTextView.text = "Description"
            }

            R.id.policyDropdown -> {

            }
        }

    }

}