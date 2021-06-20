package com.skripsi.hewanlangka

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class ShowObjectActivity : AppCompatActivity() {
    private var arFragment: ArFragment? = null
    private var modelRenderable: ModelRenderable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_object)
        arFragment = supportFragmentManager.findFragmentById(R.id.fragment) as ArFragment?

        val status = intent.getStringExtra("status")

        when(status){
            "benteng" ->{
                setUpModelBanteng()
                setUpPlane()
            }
            "anoa" ->{
                setUpModelAnoa()
                setUpPlane()
            }
            "yaki" ->{
                setUpModelYaki()
                setUpPlane()
            }
            "anjing" -> {
                setUpModelDog()
                setUpPlane()
            }
            "kijangkuning" ->{
                setUpModelKijangKuning()
                setUpPlane()
            }
            "kodokmerah" ->{
                setUpModelKodokMerah()
                setUpPlane()
            }
            "kurakura" ->{
                setUpModelKuraLeherPanjang()
                setUpPlane()
            }
            "penyu" ->{
                setUpModelPenyuSisik()
                setUpPlane()
            }
            "buaya" -> {
                setUpModelBuayaMuara()
                setUpPlane()
            }
            "sancatimor" -> {
                setUpModelSancaTimor()
                setUpPlane()
            }
            "sancahijau" -> {
                setUpModelSancaHijau()
                setUpPlane()
            }
        }
    }

    private fun setUpModelBanteng() {
        ModelRenderable.builder()
            .setSource(this, R.raw.cattle)
            .build()
            .thenAccept { renderable: ModelRenderable? ->
                modelRenderable = renderable
            }
            .exceptionally { throwable: Throwable? ->
                Toast.makeText(this@ShowObjectActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
                    .show()
                null
            }
    }

    private fun setUpModelAnoa() {
        ModelRenderable.builder()
            .setSource(this, R.raw.goat)
            .build()
            .thenAccept { renderable: ModelRenderable? ->
                modelRenderable = renderable
            }
            .exceptionally { throwable: Throwable? ->
                Toast.makeText(this@ShowObjectActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
                    .show()
                null
            }
    }

    private fun setUpModelYaki() {
        ModelRenderable.builder()
            .setSource(this, R.raw.monkey)
            .build()
            .thenAccept { renderable: ModelRenderable? ->
                modelRenderable = renderable
            }
            .exceptionally { throwable: Throwable? ->
                Toast.makeText(this@ShowObjectActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
                    .show()
                null
            }
    }

    private fun setUpModelDog() {
        ModelRenderable.builder()
            .setSource(this, R.raw.fox)
            .build()
            .thenAccept { renderable: ModelRenderable? ->
                modelRenderable = renderable
            }
            .exceptionally { throwable: Throwable? ->
                Toast.makeText(this@ShowObjectActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
                    .show()
                null
            }
    }

    private fun setUpModelKijangKuning() {
        ModelRenderable.builder()
            .setSource(this, R.raw.rusakuning)
            .build()
            .thenAccept { renderable: ModelRenderable? ->
                modelRenderable = renderable
            }
            .exceptionally { throwable: Throwable? ->
                Toast.makeText(this@ShowObjectActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
                    .show()
                null
            }
    }

    private fun setUpModelKodokMerah() {
        ModelRenderable.builder()
            .setSource(this, R.raw.poisondartfrog)
            .build()
            .thenAccept { renderable: ModelRenderable? ->
                modelRenderable = renderable
            }
            .exceptionally { throwable: Throwable? ->
                Toast.makeText(this@ShowObjectActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
                    .show()
                null
            }
    }

    private fun setUpModelKuraLeherPanjang() {
        ModelRenderable.builder()
            .setSource(this, R.raw.turtle)
            .build()
            .thenAccept { renderable: ModelRenderable? ->
                modelRenderable = renderable
            }
            .exceptionally { throwable: Throwable? ->
                Toast.makeText(this@ShowObjectActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
                    .show()
                null
            }
    }

    private fun setUpModelPenyuSisik() {
        ModelRenderable.builder()
            .setSource(this, R.raw.penyusisik)
            .build()
            .thenAccept { renderable: ModelRenderable? ->
                modelRenderable = renderable
            }
            .exceptionally { throwable: Throwable? ->
                Toast.makeText(this@ShowObjectActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
                    .show()
                null
            }
    }

    private fun setUpModelBuayaMuara() {
        ModelRenderable.builder()
            .setSource(this, R.raw.buayamuara)
            .build()
            .thenAccept { renderable: ModelRenderable? ->
                modelRenderable = renderable
            }
            .exceptionally { throwable: Throwable? ->
                Toast.makeText(this@ShowObjectActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
                    .show()
                null
            }
    }

    private fun setUpModelSancaTimor() {
        ModelRenderable.builder()
            .setSource(this, R.raw.sancatimor)
            .build()
            .thenAccept { renderable: ModelRenderable? ->
                modelRenderable = renderable
            }
            .exceptionally { throwable: Throwable? ->
                Toast.makeText(this@ShowObjectActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
                    .show()
                null
            }
    }

    private fun setUpModelSancaHijau() {
        ModelRenderable.builder()
            .setSource(this, R.raw.sancahijau)
            .build()
            .thenAccept { renderable: ModelRenderable? ->
                modelRenderable = renderable
            }
            .exceptionally { throwable: Throwable? ->
                Toast.makeText(this@ShowObjectActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
                    .show()
                null
            }
    }

    private fun setUpPlane() {
        arFragment!!.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            val anchor = hitResult.createAnchor()
            val anchorNode =
                AnchorNode(anchor)
            anchorNode.setParent(arFragment!!.arSceneView.scene)
            createModel(anchorNode)
        }
    }

    private fun createModel(anchorNode: AnchorNode) {
        val node = TransformableNode(arFragment!!.transformationSystem)
        node.setParent(anchorNode)
        node.renderable = modelRenderable
        node.select()
    }
}