
package com.amin.bluetoothmanitor.activity

import android.bluetooth.BluetoothAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amin.bluetoothmanitor.R
import com.webianks.bluechat.BluetoothChatService
import com.webianks.bluechat.DeviceData
import com.webianks.bluechat.DevicesRecyclerViewAdapter


class ControlActivity : AppCompatActivity(), DevicesRecyclerViewAdapter.ItemClickListener {

    private val REQUEST_ENABLE_BT = 123
    private val TAG = javaClass.simpleName
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerViewScan: RecyclerView
    private lateinit var recyclerViewPaired: RecyclerView
    private val mDeviceList = arrayListOf<DeviceData>()
    private lateinit var devicesAdapter: DevicesRecyclerViewAdapter
    private var mBtAdapter: BluetoothAdapter? = null
    private val PERMISSION_REQUEST_LOCATION = 123
    private val PERMISSION_REQUEST_LOCATION_KEY = "PERMISSION_REQUEST_LOCATION"
    private var alreadyAskedForPermission = false
    private lateinit var headerLabel: TextView
    private lateinit var headerLabelPaired: TextView
    private lateinit var headerLabelContainer: LinearLayout
    private lateinit var status: TextView
    private lateinit var connectionDot: ImageView
    private lateinit var  mConnectedDeviceName: String
    private var connected: Boolean = false

    private var mChatService: BluetoothChatService? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)

        progressBar = findViewById(R.id.progress_bar)
        recyclerViewScan = findViewById(R.id.scan_recycler_view)
        recyclerViewPaired = findViewById(R.id.pair_recycler_view)

//        recyclerViewScan.scroll


    }


    override fun itemClicked(deviceData: DeviceData) {

    }

}