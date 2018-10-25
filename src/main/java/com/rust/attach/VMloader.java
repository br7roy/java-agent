 /*
  * Package com.rust.attach
  * FileName: VMloader
  * Author:   Rust
  * Date:     2018/10/25 22:21
  */
 package com.rust.attach;

 import com.sun.tools.attach.AgentInitializationException;
 import com.sun.tools.attach.AgentLoadException;
 import com.sun.tools.attach.AttachNotSupportedException;
 import com.sun.tools.attach.VirtualMachine;

 import java.io.IOException;

 /**
  * @author Rust
  */
 public class VMloader {
	 public static void main(String[] args) throws IOException, AgentLoadException, AgentInitializationException, AttachNotSupportedException {
		 if (args.length != 2) {
			 System.err.println("Usage 2 params");
			 System.exit(-1);
		 }
		 VirtualMachine vm = VirtualMachine.attach(args[0]);
		 try {
			 vm.loadAgent(args[1]);
		 } finally {
			 vm.detach();
		 }
	 }
 }
