package venus.simulator

class VectorRegister(val len : Int) {
    var content = IntArray(len)

    /** add vs1 to vs2 and save to this (vd) */
    fun vecadd(vs1 : VectorRegister, vs2 : VectorRegister) {
        for (i in 1..len) {
            content[i] = vs1.content[i] + vs2.content[i]
        }
    }

    /** multiply vs1 to vs2 and save to this (vd) */
    fun vecmul(vs1 : VectorRegister, vs2 : VectorRegister) {
        for (i in 1..len) {
            content[i] = vs1.content[i] * vs2.content[i]
        }
    }
}
