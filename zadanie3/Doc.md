Mobilny Kalendarz WEEIA

- URL

    `/calendar`

- Metoda
    
    GET
    
- Parametry 
    
    Opcjonalne:
    
    - year = [Integer]
    
      Rok, z którego chcemy wygenerować kalendarza. W przypadku braku tego parametru, domyślnie ustawiany jest rok bierzący.
      
    - month = [Integer]
    
      Miesiąc, z którego chcemy wygenerować kalendarz. W przypadku braku tego parametru, domyślnie ustawiany jest miesiąc bierzący.

- Odpowiedzi
    
    - Jeśli podamy nieprawidłową wartość miesiąca, tj mniejsze od 1 lub większe od 12:
         ```
        {
            "message": "Wrong month value"
        }
        ```

    - Jeśli podamy nieprawidłową wartość roku, tj mniejsze od 1:
        ```
        {
            "message": "Wrong year value"
        }
        ```
    - Jeśli wywołamy endpoint `/calendar` bez podanych parametrów otrzymamy plik .ics na bierzący rok i miesiąc
        
        ```
        BEGIN:VCALENDAR
        VERSION:2.0
        PRODID:-//Michael Angstadt//biweekly 0.6.3//EN
        BEGIN:VEVENT
        UID:fcb14bf3-8a72-40a3-bbc3-0032ef9ef887
        DTSTAMP:20191112T155447Z
        SUMMARY:First Step to Fields Medal
        DTSTART:20191103T230000Z
        DTEND:20191103T230000Z
        END:VEVENT
        BEGIN:VEVENT
        UID:22f5e2f6-2af6-43e4-ae9f-81b762574d7d
        DTSTAMP:20191112T155447Z
        SUMMARY:First Step to Success
        DTSTART:20191105T230000Z
        DTEND:20191105T230000Z
        END:VEVENT
        BEGIN:VEVENT
        UID:ebf8883d-b9ba-4054-81ef-6cef8da73d64
        DTSTAMP:20191112T155447Z
        SUMMARY:First Step to Nobel Prize
        DTSTART:20191107T230000Z
        DTEND:20191107T230000Z
        END:VEVENT
        BEGIN:VEVENT
        UID:b693c61b-6044-447f-b405-c0b0dcffb065
        DTSTAMP:20191112T155447Z
        SUMMARY:Fascynująca Fizyka - poziom podstawowy
        DTSTART:20191114T230000Z
        DTEND:20191114T230000Z
        END:VEVENT
        END:VCALENDAR
        ```

    - Jeśli wywołamy endpoint `/calendar` z prawidłowo podanymi parametrami, tj. `/calendar?year=2019&month=12`, to otrzymamy  plik .ics na zdefiniowany w parametrach rok i miesiąc

        ```
        BEGIN:VCALENDAR
        VERSION:2.0
        PRODID:-//Michael Angstadt//biweekly 0.6.3//EN
        BEGIN:VEVENT
        UID:b1f1c9f3-cc20-44b1-83b2-9785cbee70d0
        DTSTAMP:20191112T155742Z
        SUMMARY:Matura próbna Matematyka podstawowa
        DTSTART:20191215T230000Z
        DTEND:20191215T230000Z
        END:VEVENT
        BEGIN:VEVENT
        UID:cbac15c7-b5aa-42c9-9759-eaa9e6dfd6b1
        DTSTAMP:20191112T155742Z
        SUMMARY:Matura próbna Matematyka rozszerzona
        DTSTART:20191216T230000Z
        DTEND:20191216T230000Z
        END:VEVENT
        BEGIN:VEVENT
        UID:6c4953a4-9363-4593-b45d-993c486d30a3
        DTSTAMP:20191112T155742Z
        SUMMARY:Matura próbna Fizyka rozszerzona
        DTSTART:20191217T230000Z
        DTEND:20191217T230000Z
        END:VEVENT
        BEGIN:VEVENT
        UID:20fcaaa8-6771-482c-a1b4-ff72a6252be4
        DTSTAMP:20191112T155742Z
        SUMMARY:Matura próbna Chemia rozszerzona
        DTSTART:20191218T230000Z
        DTEND:20191218T230000Z
        END:VEVENT
        BEGIN:VEVENT
        UID:99f75076-6430-44b6-868b-38dfed642873
        DTSTAMP:20191112T155742Z
        SUMMARY:First Step to Nobel Prize
        DTSTART:20191205T230000Z
        DTEND:20191205T230000Z
        END:VEVENT
        BEGIN:VEVENT
        UID:bbd5b7e9-4d2c-4be4-bcb0-f4590b54fa26
        DTSTAMP:20191112T155742Z
        SUMMARY:First Step to Fields Medal
        DTSTART:20191208T230000Z
        DTEND:20191208T230000Z
        END:VEVENT
        BEGIN:VEVENT
        UID:f43629b8-666b-41a1-b890-c6ccdd9cb74e
        DTSTAMP:20191112T155742Z
        SUMMARY:Fascynująca Fizyka - poziom ponadpodstawowy
        DTSTART:20191210T230000Z
        DTEND:20191210T230000Z
        END:VEVENT
        END:VCALENDAR
        ```
