class Solution:
    def isValid(self, s: str) -> bool:
        box = ""
        for x in s.strip():
            box += x

            if box[-2:] in ["{}", "()", "[]"]:
                box = box[:-2]
        
        if box == "":
            return True
        else:
            False
