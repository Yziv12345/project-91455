package com.project.animalproject91455.interfaces;

public class StatusType {

   private boolean status = false;

   public StatusType(boolean status) {
       this.status = status;
   }

   public boolean getStatus() {
       return this.status;
   }

   public void seStatus(boolean status) {
       this.status = status;
   }

}
