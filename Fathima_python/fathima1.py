class Instructor:
    
    instructorname,avgfeedback,experience,skillset ="",0.0,0,[]

    def __init__(self,instructorname,avgfeedback,experience,skillset):
        self.instructorname = instructorname
        self.avgfeedback = avgfeedback
        self.experience = experience
        self.skillset = skillset
        
    def validateEligibility(self):
        return (True if ((self.avgfeedback > 4.5 and self.experience > 3) or (self.avgfeedback > 4.0 and self.experience <= 3)) else False)
    
    def checkSkills(self,technology):  
        return(True if technology in self.skillset else False)

obj1 = Instructor("asda",4.5,3,["Java","python"])
'''-----Can Have many Objects for different users-----'''

if(obj1.validateEligibility()):
    print("She is appointed" if(obj1.checkSkills(input("Enter a Skill set"))) else "Not available for selected subject")
else:
    print("-----Not eligible-----")