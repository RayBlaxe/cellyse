package com.project.celllyse

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.project.celllyse.databinding.FragmentPrediksiBinding
import org.json.JSONException
import org.json.JSONObject
import java.nio.charset.Charset

class PrediksiFragment : Fragment() {
    private lateinit var binding: FragmentPrediksiBinding
    private val url = "https://raihankh.pythonanywhere.com/predict"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrediksiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPrediksi.setOnClickListener {
//            print a console log
            Log.d("PrediksiFragment", "Button Prediksi clicked")
            val jsonObject = JSONObject()
            jsonObject.put("umur", binding.edtUmur.text.toString())
            jsonObject.put("jenisKelamin", binding.edtJenisKelamin.text.toString())
            jsonObject.put("seranganFisik", binding.edtIsSeranganFisik.text.toString())
            jsonObject.put("pertengkaran", binding.edtIsPertengkaran.text.toString())
            jsonObject.put("kesepian", binding.edtIsKesepian.text.toString())
            jsonObject.put("temanDekat", binding.edtTemanDekat.text.toString())
            jsonObject.put("bolos", binding.edtIsBolos.text.toString())
            jsonObject.put("sukaBantu", binding.edtIsSukaMembantu.text.toString())
            jsonObject.put("ortuPaham", binding.edtisOrtuMemahami.text.toString())
            jsonObject.put("seringKesepian", binding.edtIsSeringKesepian.text.toString())
            jsonObject.put("bolosIzin", binding.edtIsBolosIzin.text.toString())
            jsonObject.put("kurangBerat", binding.edtKekuranganBerat.text.toString())
            jsonObject.put("lebihBerat", binding.edtKelebihanBerat.text.toString())
            jsonObject.put("obesitas", binding.edtIsObesitas.text.toString())
            val requestBody = jsonObject.toString()

            val jsonObjectRequest = object : JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonObject,
                Response.Listener { response ->
                    try {
                        Log.d("Response", response.toString()) // Log the entire response for inspection

                        if (response.has("result")) {
                            val data = response.getString("result")
                            binding.edtHasilPrediksi.text = if (data == "1") {
                                "Kemungkinan pernah terbully"
                            } else {
                                "Kemungkinan tidak pernah terbully"
                            }
                        } else {
                            // Handle the case when the "result" key is not present in the response
                            binding.edtHasilPrediksi.text = "Key 'result' not found in response"
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }


                ,
                        Response.ErrorListener { error ->
                    Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
                }) {
                override fun getBodyContentType(): String {
                    return "application/json"
                }

                override fun getBody(): ByteArray {
                    return requestBody.toByteArray(Charset.defaultCharset())
                }
            }

            val queue: RequestQueue = Volley.newRequestQueue(requireContext())
            queue.add(jsonObjectRequest)
        }
    }
}
