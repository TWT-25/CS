# This program uses the MARS simulation tool to convert the below C code into MIPS. 
# int main() {
# 	int A[] = {15, 20, 35, 20, 45, 65, 20};
# 	int x = 0; int y = 20; int z = 0; 
# 	while (x < 7) {
# 		if (A[x] == y) {
#			z++;}
#		x++;}
# 	return 0;}


# Set memory for array
.data
	A: .space 28
.text
	li $t0, 15
	li $t1, 20
	li $t2, 35
	li $t3, 20
	li $t4, 45
	li $t5, 65
	li $t6, 20
	
	la $s0, A  #address of array A is in $s0
	sw $t0, 0($s0)
	sw $t1, 4($s0)
	sw $t2, 8($s0)
	sw $t3, 12($s0)
	sw $t4, 16($s0)
	sw $t5, 20($s0)
	sw $t6, 24($s0)
	
	li $s1, 0    #x
	li $s2, 20   #y
	li $s3, 0    #z
	
	Loop: slti $t7, $s1, 7      
	      beq $t7, $zero, Exit  
	      sll $s4, $s1, 2       #if section - start by setting A[x]
	      add $s4, $s0, $s4     # $s4 has address of A[x]
	      lw $s5, 0($s4)
	      bne $s5, $s2, Else
	      addi $s3, $s3, 1
	      addi $s1, $s1, 1
	      j Loop
	Else: addi $s1, $s1, 1
	      j Loop
	Exit:
	       
