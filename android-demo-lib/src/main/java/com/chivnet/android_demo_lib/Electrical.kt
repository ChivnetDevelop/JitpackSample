package com.chivnet.mylibrary_jetpack_compose

class ElectricalCalc{
    var volts:Double=0.0
    var current:Double=0.0
    var powerfactor:Double=0.0

    fun kw(v:Double,c:Double,pf:Double):Double{
        volts=v
        current=c
        powerfactor=pf
        val kilowatts= (1.732*volts*current*powerfactor)/1000
        return kilowatts
    }

    fun kvar(v:Double,c:Double,pf:Double):Double{
        volts=v
        current=c
        powerfactor=pf
        val acospf=Math.acos(powerfactor)
        val sinpf=Math.sin(acospf)
        val kilovoltampsreactive= (1.732*volts*current*sinpf)/1000
        return kilovoltampsreactive
    }

    fun kva(vt:Double,ct:Double):Double{
        volts=vt
        current=ct
        val kilovoltamps= (1.732*volts*current)/1000
        return kilovoltamps
    }
}
