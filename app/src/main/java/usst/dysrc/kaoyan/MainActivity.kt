package usst.dysrc.kaoyan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*
import usst.dysrc.kaoyan.fragments.AccountFragment
import usst.dysrc.kaoyan.fragments.PostManagementFragment
import usst.dysrc.kaoyan.fragments.SquareFragment

class MainActivity : AppCompatActivity(),RadioGroup.OnCheckedChangeListener {
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            mine_radioButton.id -> {
                changeFragment(AccountFragment(), true)
            }
            square_radioButton.id -> {
                changeFragment(SquareFragment(),true)
            }
            post_management_radioButton.id ->{
                changeFragment(PostManagementFragment(),true)
            }
            else -> {
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_radioGroup.setOnCheckedChangeListener(this)
        mine_radioButton.isChecked=true
        changeFragment(AccountFragment(),false)
    }

    private fun changeFragment(fragment: Fragment, isFirst:Boolean){
        val fragmentTransaction: FragmentTransaction =supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(main_content.id,fragment)
        if (!isFirst) fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
