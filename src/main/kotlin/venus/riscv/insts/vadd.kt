package venus.riscv.insts

import venus.riscv.insts.dsl.VectorArithInstruction
import venus.simulator.VectorRegister

val vaddvv = VectorArithInstruction(
        name = "vadd.vv",
        opcode = 0b1111111,
        funct3 = 0b000,
        funct7 = 0b0000000,
        eval32 = VectorRegister::vecadd,
        eval64 = VectorRegister::vecadd
)
