package com.amin.bluetoothmanitor

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothHeadset
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.amin.bluetoothmanitor.activity.ControlActivity
import com.amin.bluetoothmanitor.activity.MainActivity

class Splash : AppCompatActivity() {

    private val REQUET_ENABEL_BLUETOOTH = 1
    private var v_bluetoothAdapter : BluetoothAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalesh)

        v_bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

        if (v_bluetoothAdapter == null){
            Toast.makeText(this, R.string.no_available, Toast.LENGTH_LONG).show()
        }

        if (!v_bluetoothAdapter!!.isEnabled) {
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBluetoothIntent, REQUET_ENABEL_BLUETOOTH)
        }else {
           controlActivity()
        }

    }

    private fun controlActivity() {
        if(v_bluetoothAdapter!!.getProfileConnectionState(BluetoothHeadset.HEADSET) == BluetoothHeadset.STATE_CONNECTED){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            val intent = Intent(this, ControlActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUET_ENABEL_BLUETOOTH){
            if(resultCode == Activity.RESULT_OK){
                if(v_bluetoothAdapter!!.isEnabled){
                    Toast.makeText(this,R.string.is_enable,Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,R.string.is_disable,Toast.LENGTH_SHORT).show()
                }
            }else if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this,R.string.is_cancel,Toast.LENGTH_SHORT).show()
            }
            controlActivity()
        }
    }
}
