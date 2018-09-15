package usst.dysrc.kaoyan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_mine_collections.*

class MineCollectionListActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mine_collections)
        mine_collections_recyclerView.layoutManager=LinearLayoutManager(this)

    }
}