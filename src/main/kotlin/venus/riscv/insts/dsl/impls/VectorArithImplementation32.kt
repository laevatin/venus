package venus.riscv.insts.dsl.impls

import venus.riscv.InstructionField
import venus.riscv.MachineCode
import venus.simulator.Simulator
import venus.simulator.VectorRegister

class VectorArithImplementation32(private val eval: VectorRegister.(VectorRegister, VectorRegister) -> Unit) : InstructionImplementation {
    override operator fun invoke(mcode: MachineCode, sim: Simulator) {
        // TODO: add mask
        val vs1 = mcode[InstructionField.RS1]
        val vs2 = mcode[InstructionField.RS2]
        val vd = mcode[InstructionField.RD]
        val vec1 = sim.getVecReg(vs1)
        val vec2 = sim.getVecReg(vs2)
        val vec3 = sim.getVecReg(vd)
        vec3.eval(vec1, vec2)
        sim.incrementPC(mcode.length)
    }
}