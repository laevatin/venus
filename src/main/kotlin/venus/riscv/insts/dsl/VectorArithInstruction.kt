package venus.riscv.insts.dsl

import venus.riscv.insts.dsl.disasms.VectorArithDisassembler
import venus.riscv.insts.dsl.formats.VectorArithFormat
import venus.riscv.insts.dsl.impls.NoImplementation
import venus.riscv.insts.dsl.impls.VectorArithImplementation32
import venus.riscv.insts.dsl.parsers.VectorArithParser
import venus.simulator.VectorRegister

class VectorArithInstruction(
        name: String,
        opcode: Int,
        funct3: Int,
        funct7: Int,
        eval32: VectorRegister.(VectorRegister, VectorRegister) -> Unit,
        eval64: VectorRegister.(VectorRegister, VectorRegister) -> Unit = { _, _ -> throw NotImplementedError("no rv64") }
) : Instruction(
        name = name,
        format = VectorArithFormat(opcode),
        parser = VectorArithParser,
        impl32 = VectorArithImplementation32(eval32),
        impl64 = NoImplementation,
        disasm = VectorArithDisassembler
)